package com.nando.function_dispatcher

import kotlin.reflect.*

abstract class FunctionDispatcher {

    protected val listeners: ArrayList<Pair<String, KFunction<Any>>> = arrayListOf()

    protected fun bindFunction(self: Any, function: KFunction<Unit>) {
        if (canBind(self, function)) {
            listeners.add(Pair("${self.javaClass.name}_${function.name}", function))
        }
    }

    fun unbind(self: Any, function: KFunction<Unit>) {
        val listener = listeners.find { it.first == getBindName(self, function) }
        if (listener != null) listeners.remove(listener)
    }

    fun unbindAll() {
        listeners.clear()
    }

    private fun canBind(self: Any, function: KFunction<Unit>): Boolean {
        if (function.visibility != KVisibility.PUBLIC) {
            error("Function is not public")
        }

        if (isBound(self, function)) {
            error("Function is not public")
        }

        return true
    }

    fun isBound(self: Any, function: KFunction<Unit>): Boolean {
        for (listener in listeners) {
            if (listener.first == getBindName(self, function)) return true
        }
        return false
    }

    private fun getBindName(self: Any, function: KFunction<Unit>): String {
        return "${self.javaClass.name}_${function.name}"
    }

}

class FunctionDispatcherNoParams: FunctionDispatcher() {

    fun bind(self: Any, function: KFunction<Unit>) {
        super.bindFunction(self, function)
    }

    fun broadcast() {
        listeners.forEach {
            it.second.call()
        }
    }
}

class FunctionDispatcherOneParam<P1>: FunctionDispatcher() {

    fun bind(self: Any, function: KFunction1<P1, Unit>) {
        super.bindFunction(self, function)
    }

    fun broadcast(p1: P1) {
        listeners.forEach {
            it.second.call(p1)
        }
    }

}

class FunctionDispatcherTwoParams<P1, P2>: FunctionDispatcher() {

    fun bind(self: Any, function: KFunction2<P1, P2, Unit>) {
        super.bindFunction(self, function)
    }

    fun broadcast(p1: P1, p2: P2) {

        listeners.forEach {
            it.second.call(p1, p2)
        }
    }
}

class FunctionDispatcherThreeParams<P1, P2, P3>: FunctionDispatcher() {

    fun bind(self: Any, function: KFunction3<P1, P2, P3, Unit>) {
        super.bindFunction(self, function)
    }

    fun broadcast(p1: P1, p2: P2, p3: P3) {

        listeners.forEach {
            it.second.call(p1, p2, p3)
        }
    }
}

class FunctionDispatcherFourParams<P1, P2, P3, P4>: FunctionDispatcher() {

    fun bind(self: Any, function: KFunction4<P1, P2, P3, P4, Unit>) {
        super.bindFunction(self, function)
    }

    fun broadcast(p1: P1, p2: P2, p3: P3, p4: P4) {

        listeners.forEach {
            it.second.call(p1, p2, p3, p4)
        }
    }
}

class FunctionDispatcherFiveParams<P1, P2, P3, P4, P5>: FunctionDispatcher() {

    fun bind(self: Any, function: KFunction5<P1, P2, P3, P4, P5, Unit>) {
        super.bindFunction(self, function)
    }

    fun broadcast(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5) {

        listeners.forEach {
            it.second.call(p1, p2, p3, p4, p5)
        }
    }
}

class FunctionDispatcherSixParams<P1, P2, P3, P4, P5, P6>: FunctionDispatcher() {

    fun bind(self: Any, function: KFunction6<P1, P2, P3, P4, P5, P6, Unit>) {
        super.bindFunction(self, function)
    }

    fun broadcast(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6) {

        listeners.forEach {
            it.second.call(p1, p2, p3, p4, p5, p6)
        }
    }
}

class FunctionDispatcherSevenParams<P1, P2, P3, P4, P5, P6, P7>: FunctionDispatcher() {

    fun bind(self: Any, function: KFunction7<P1, P2, P3, P4, P5, P6, P7, Unit>) {
        super.bindFunction(self, function)
    }

    fun broadcast(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7) {

        listeners.forEach {
            it.second.call(p1, p2, p3, p4, p5, p6, p7)
        }
    }
}

class FunctionDispatcherEightParams<P1, P2, P3, P4, P5, P6, P7, P8>: FunctionDispatcher() {

    fun bind(self: Any, function: KFunction8<P1, P2, P3, P4, P5, P6, P7, P8, Unit>) {
        super.bindFunction(self, function)
    }

    fun broadcast(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8) {

        listeners.forEach {
            it.second.call(p1, p2, p3, p4, p5, p6, p7, p8)
        }
    }
}

class FunctionDispatcherNineParams<P1, P2, P3, P4, P5, P6, P7, P8, P9>: FunctionDispatcher() {

    fun bind(self: Any, function: KFunction9<P1, P2, P3, P4, P5, P6, P7, P8, P9, Unit>) {
        super.bindFunction(self, function)
    }

    fun broadcast(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9) {
        listeners.forEach {
            it.second.call(p1, p2, p3, p4, p5, p6, p7, p8, p9)
        }
    }
}
