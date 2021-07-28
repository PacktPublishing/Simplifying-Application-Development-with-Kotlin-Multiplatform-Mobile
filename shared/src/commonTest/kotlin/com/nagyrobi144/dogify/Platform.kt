package com.nagyrobi144.dogify

import kotlinx.coroutines.CoroutineScope

expect fun <T> runTest(block: suspend CoroutineScope.() -> T): T