
import com.zhw1.Person
import com.zhwlearn.Animal
import com.zhwlearn.Department
import com.zhwlearn.Employee
import com.zhwlearn.RectArea
import java.math.BigDecimal
import java.util.*
import javax.lang.model.element.NestingKind

/**
 * Created by sfghjtj on 2018/3/28.
 */

fun main(args: Array<String>) {

    var a = RectArea(1, 2, 4)
    println(a.area)
    var b= Person("zhw", Date(),25)

}

fun cal(n1: Int, n2: Int, opt: Char = '+'): Int {
    val mul = 2
    val result = if ('+' == opt) {
        fun(a: Int, b: Int) = (a + b) * mul //匿名函数多用于局部函数中
    } else {
        fun(a: Int, b: Int) = (a - b) * mul
    }
    return result(n1, n2)
}

fun Double.interfate(rate: Double) = this * rate
infix fun Double.interfate2(rate: Double) = this * rate //中缀运算符的定义，只能是成员函数或扩展函数进行定义。


class Account{
    var amount: Double = 0.0
    var owner: String = "zhw"
    var desc: String = "成员: $amount - $owner"

    fun display()="[成员: $amount - $owner]"
    infix fun pus(a: Int)=a+amount
}


fun Account.interfate(rate: Double) = this.amount * rate
val Account.desc: String
    get() = "Account desc[amount= ${this.amount},owner= ${this.owner} ]"
fun Account.display(s: String)="[Account: $s desc[amount= ${this.amount},owner= ${this.owner} ]]"




val Int.message: String
    get() = when(this){
    -1 -> "没有数据"
    -2 -> "日期没有输入"
    else -> "success access!"
}


