/*
 * Connection.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.hellowordkmp.mobile.utils.connection

import dev.jordond.connectivity.ConnectivityProvider

expect fun getConnectivityProvider(): ConnectivityProvider
