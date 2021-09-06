package org.jetbrains.skia.impl

actual abstract class Native actual constructor(ptr: Long) {
    actual var _ptr: Long
    override fun toString(): String {
        return this::class.simpleName + "(_ptr=0x" + _ptr.toString(16) + ")"
    }

    actual open fun _nativeEquals(other: Native?): Boolean = TODO()

    actual companion object {
        actual fun getPtr(n: Native?): Long {
            return n?._ptr ?: 0
        }
    }

    init {
        if (ptr == 0L) throw RuntimeException("Can't wrap nullptr")
        _ptr = ptr
    }
}

actual fun reachabilityBarrier(obj: Any?) {
    // TODO: implement native barrier
}