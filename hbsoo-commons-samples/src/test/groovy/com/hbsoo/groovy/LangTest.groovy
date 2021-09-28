package com.hbsoo.groovy

/**
 * Created by zun.wei on 2021/9/27.
 *
 */
class LangTest {


    static void main(String[] args) {
        0.upto(2) { println "it1 = $it" }
        3.times { println "it2 = $it" }
        0.step(10, 2) { println "it3 = $it" }
        def s = "help".execute().text
        println "s = $s"
        test("abcdef")

    }


    static def test(str) {
        println "{} = ${str?.reverse()}"
    }

}
