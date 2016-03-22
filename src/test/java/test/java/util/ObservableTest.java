package test.java.util;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.everyItem;
import static org.junit.Assert.assertThat;

/**
 * Created by L.x on 16-3-4.
 */
public class ObservableTest {

    private final Publisher publisher = new Publisher();
    private List<Subscriber> subscribers;

    @Before
    public void setUp() throws Exception {
        assertThat(publisher.countObservers(), equalTo(0));

        int subscribersToAdded = 10;
        subscribers = numberOfSubscribers(subscribersToAdded);
        for (Subscriber subscriber : subscribers) {
            publisher.addObserver(subscriber);
        }

        assertThat(publisher.countObservers(), equalTo(subscribersToAdded));

    }

    @Test
    public void notifyAllSubscribersWhenChanged() throws Exception {
        publisher.whenChanged().notifyObservers();

        assertThat(subscribers, everyItem(hasBeenNotified()));
    }

    @Test
    public void notifyAllSubscribersWithArgumentWhenChanged() throws Exception {
        publisher.whenChanged().notifyObservers("foo");

        assertThat(subscribers, everyItem(hasBeenNotifiedWithArg("foo")));
    }

    @Test
    public void cannotNotifyAllSubscribersWhenIfNotChanged() throws Exception {
        publisher.notifyObservers();

        assertThat(subscribers, everyItem(not(hasBeenNotified())));
    }

    private List<Subscriber> numberOfSubscribers(int count) {
        List<Subscriber> subscribers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            subscribers.add(new Subscriber());
        }
        return subscribers;
    }

    private Matcher<Subscriber> hasBeenNotified() {
        return new FeatureMatcher<Subscriber, Boolean>(is(true), "notified", "notified") {
            @Override
            protected Boolean featureValueOf(Subscriber actual) {
                return actual.isNotified();
            }

        };
    }

    private Matcher<Subscriber> hasBeenNotifiedWithArg(Object expectedArg) {
        return allOf(hasBeenNotified(), notifiedWithArg(expectedArg));
    }

    private FeatureMatcher<Subscriber, Object> notifiedWithArg(final Object expectedArg) {
        return new FeatureMatcher<Subscriber, Object>(equalTo(expectedArg), "notified with argument was", ", but argument") {
            @Override
            protected Object featureValueOf(Subscriber actual) {
                return actual.receivedArgument();
            }
        };
    }

    private static class Subscriber implements Observer {
        private boolean notified;
        public Object received;

        @Override
        public void update(Observable o, Object arg) {
            notified = true;
            this.received = arg;
        }

        private boolean isNotified() {
            return notified;
        }

        private Object receivedArgument() {
            return received;
        }
    }

    private static class Publisher extends Observable {

        public Publisher whenChanged() {
            setChanged();
            return this;
        }
    }
}
