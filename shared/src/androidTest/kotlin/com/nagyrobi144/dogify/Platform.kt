package com.nagyrobi144.dogify

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

actual fun <T> runTest(block: suspend CoroutineScope.() -> T) = runBlocking(block = block)