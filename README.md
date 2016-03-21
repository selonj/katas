#   Katas

##  What a kata?
>   a [kata](http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata) study it as a form, not as a conclusion. It is not the conclusion of the kata that matters, it's the steps that lead to the conclusion. If you want to lean to think the way I think, to design the way I design, then you must learn to react to minutia the way I react. Following this form will help you to do that. As you learn the form, and repeat it, and repeat it, you will condition your mind and body to respond the way I respond to the minute factors that lead to design decisions.

##  Referneces 
- [x] [a short introduction of TDD](etc/TDD_content.pdf)

##  [删除有序数组中的重复元素](src/test/java/com/selonj/katas/UniqueOrderedArrayTest.java)

伪代码:
```pseudo-code
unique([1,1,2,2,3,3])==[1,2,3]
```

##  [求解一个数的素因数](src/test/java/com/selonj/katas/PrimeFactorsTest.java)

伪代码:
```pseudo-code
PrimeFactors.of(30)==[2,3,5]
```

## [保龄球游戏](src/test/java/com/selonj/katas/BowlingGameTest.java)

![保龄球游戏](etc/bowling-game.png)

> 保龄球一局分为10轮,每轮有两次投球的机会来击倒10个球瓶,通过击倒的瓶数多少来计分.

**计分规则：**

- 一轮如果未全部击倒球瓶,则该轮计分为击倒的瓶数.如：第一轮第一次击倒1个,第二次击倒4个,该轮得分为5分
- 一轮中第一次击倒所有球瓶,即**全中**,该轮取消第二次投球,并把接下来两次投球击倒瓶数作为该轮的奖励,如：第5轮第一次击倒10个,下轮两次分别击倒0和1个球瓶,该轮得分为11分
- 一轮中两次击倒所有球瓶,即**补中**,并把接下来的一次投球击倒瓶数作为该轮的奖励,如：第3轮击倒10个,下轮两次分别击倒5和5个球瓶,该轮计分为15分.
-  在10轮中,如果投得全中,仍要继续投完最后两个球;如果是补中,就要继续投完最后一球,结束全局.

## [比较字符串排列是否同一排列](src/test/java/com/selonj/katas/StringPermutationTest.java)

伪代码:
```pseudo-code
permutation?('abc','bca')==true
permutation?('abc','bac')==false
permutation?('good','odgo')==true
```

## [版本号比较](src/test/java/com/selonj/katas/VersionComparisonTest.java)

伪代码:
```pseudo-code
'3.1.2'.compare('3.1')== 1
'12.0.0'.compare('11.0.0')== -1
'11.0.0'.compare('11')==0
```

## [建造URL中的queryString](src/test/java/com/selonj/katas/QueryStringTest.java)


伪代码:
```pseudo-code
QueryString.within(param('foo','bar'),param('key','value')).toString() == ?foo=bar&key=value
```

## [BerlinClock](src/test/java/com/selonj/katas/BerlinClockTest.java) 
[![berlin clock](etc/berlin-clock.jpg)](https://en.wikipedia.org/wiki/Mengenlehreuhr)

[BerlinClock](https://en.wikipedia.org/wiki/Mengenlehreuhr)是首个使用着色的指示灯来显示时间。

-   前两排指示灯用来显示小时，后两排指示灯显示分钟。
-   第一排的4个红色指示灯每个表示5小时；
-   第二排的4个红色指示灯每个表示1小时；
-   第三排的11个红/黄色指示灯每个表示5分钟（15、30和45分钟的指示灯为红色）；
-   最后一排的4个黄色指示灯每个表示1分钟；


## [从url中提取domain](src/test/java/com/selonj/katas/DomainTest.java)

``` pseudo-code
Domain.from('http://www.google.com/search?word=kata') == 'google.com'
Domain.from('http://code.google.com/project') == 'google.com'
```

##  [FuzzBuzz](src/test/java/com/selonj/katas/FuzzBuzzTest.java)

```pseudo-code
FuzzBuzz.of(1)=='1'
FuzzBuzz.of(3)=='Fuzz'
FuzzBuzz.of(5)=='Buzz'
FuzzBuzz.of(15)=='FuzzBuzz'
```

## [Fibonacci](src/test/java/com/selonj/katas/FibonacciTest.java)

```pseudo-code
Fib.of(1)==1
Fib.of(2)==1
Fib.of(n)=Fib.of(n-1)+Fib.of(n-2)
```

## [Factorial](src/test/java/com/selonj/katas/FactorialTest.java)

```pseudo-code
Factorial.of(n)=1*2*3*...*n
```

##  [Greatest Common Divisor](src/test/java/com/selonj/katas/GCDTest.java)

```pseudo-code
gcd(6,4)=2
```

##  [Least Common Multiple](src/test/java/com/selonj/katas/LCMTest.java)

```pseudo-code
lcm(6,4)=12
```

## [Variable Picker](src/test/java/com/selonj/katas/vp/VariablePickerAcceptanceTest.java)
从数据源中提取所有的变量,变量的格式为varName:type?:defaultValue

|varName            |   type                  |   defaultValue |
|-------------------|-------------------------|----------------|
|变量名可以为任意字符 |可以转换的Java任意类型      |默认值           |       

```pseudo-code
pick variables from '本次${name:string}将于${time:date?:2014-05-12}日抵达${destination:Location?:北京}' 
return variables as list: [name,time,destination]
```

## [reverse a string](src/test/java/com/selonj/katas/StringReversionTest.java)

```pseudo-code
reverse("abcdefg")=="gfedcba";
```

## WordWrap

```pseudo-code
WordWrap.of(any(int)).wrap("") == "";
WordWrap.of(6).wrap("word") == "word";
WordWrap.of(5).wrap("word word") == "word\nword";
WordWrap.of(5).wrap("word word") == "word\nword";
WordWrap.of(5).wrap("word word word") == "word\nword\nword";
WordWrap.of(10).wrap("word word word") == "word word\nword";
WordWrap.of(4).wrap("wordword") == "word\nword";
WordWrap.new(3).wrap("word word word") == "wor\nd\nwor\nd\nwor\d";
```