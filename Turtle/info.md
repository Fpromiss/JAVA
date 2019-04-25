## 实验一：海龟语言解释器

海龟语言以Program标记程序开始，以end标记程序结束支持以下命令。

* go 10:前进10步
* turn 30: 转30度，范围可以从0-360度
* repeat 10  <命令列表>：重复命令列表中命令10次
* 命令列表：有go， turn和repeat命令构成，命令间以空格分隔，命令列表以end结尾

构造一个海龟语言解释器，以及Junit测试代码。至少包含以下的测试用例：

##### 输入	

* program end

##### 输出

* 

##### 输入

* program go 5 end

##### 输出

* go 5

##### 输入	

* program go 1 turn 10 go 2 turn 20 go 3 turn 30 go 4 turn 40 end

##### 输出

* go 1 turn 10 go 2 turn 20 go 3 turn 30 go 4 turn 40

##### 输入	

* program repeat 4 go 10 turn 10 end end

##### 输出

* go 10 turn 10 go 10 turn 10 go 10 turn 10 go 10 turn 10

##### 输入	
program repeat 4 go 10 turn 10  repeat 3 go 20  turn 20 end end turn 30  end

##### 输出

* go 10 turn 10 go 20 turn 20 go 20 turn 20 go 20 turn 20 o 10 turn 10 go 20 turn 20 go 20 turn 20 go 20 turn 20 o 10 turn 10 go 20 turn 20 go 20 turn 20 go 20 turn 20 o 10 turn 10 go 20 turn 20 go 20 turn 20 go 20 turn 20 turn 30

##### 输入	

* program turn 10 repeat 2 turn 20 go 10 end go 10 repeat 3 turn 30 go 30 end go 40 end

##### 输出

* turn 10 turn 20 go 10 turn 20 go 10 go 10 turn 30 go 30 turn 30 go 30 turn 30 go 30 go 40




.


