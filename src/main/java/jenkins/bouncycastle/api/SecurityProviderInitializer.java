/*
 * The MIT License
 *
 * Copyright (c) 2016-2021, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jenkins.bouncycastle.api;

import java.util.logging.Logger;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

/**
 * Initialization class to register Bouncy Castle as a security provider.
 *
 * @since 1.0
 */
public class SecurityProviderInitializer {

    private static final Logger LOGGER = Logger.getLogger(SecurityProviderInitializer.class.getName());

    /**
     * Initializes JVM security to Bouncy Castle. This initialization should be done before any plugin is loaded in
     * order to ensure that the provider is available to any plugin that needs it and that we are the first to register
     * it.
     *
     */
    @Restricted(NoExternalUse.class)
    static void addSecurityProvider() {
        LOGGER.fine("Initializing Bouncy Castle security provider.");
        BcProviderRegistration.register();
        LOGGER.fine("Bouncy Castle security provider initialized.");
    }
}
