package javasolutions.dynamic;

public class CountAllValidPickupAndDeliveryOptions {

    private static final int MOD = 1_000_000_007;

    public int countOrders(int n) {
        long result = 1;

        for (int i = 1; i <= 2 * n; ++i) {
            result = result * i;

            if (i % 2 == 0) {
                result = result / 2;
            }
            result %= CountAllValidPickupAndDeliveryOptions.MOD;
        }
        return (int) result;
    }

    //############################################################################

    private long[][] tabulation;

    private long totalWays(int unpicked, int undelivered) {
        if (unpicked == 0 && undelivered == 0) {
            // We have completed all orders.
            return 1;
        }

        if (unpicked < 0 || undelivered < 0 || undelivered < unpicked) {
            // We can't pick or deliver more than N items
            // Number of deliveries can't exceed number of pickups
            // as we can only deliver after a pickup.
            return 0;
        }

        if (tabulation[unpicked][undelivered] != 0) {
            // Return cached value, if already present.
            return tabulation[unpicked][undelivered];
        }

        long ans = 0;

        // Count all choices of picking up an order.
        ans += unpicked * totalWays(unpicked - 1, undelivered);
        // Handle integer overflow.
        ans %= MOD;

        // Count all choices of delivering a picked order.
        ans += (undelivered - unpicked) * totalWays(unpicked, undelivered - 1);
        // Handle integer overflow.
        ans %= MOD;

        return tabulation[unpicked][undelivered] = ans;
    }

    public int countOrders1(int n) {
        tabulation = new long[n + 1][n + 1];
        return (int)totalWays(n, n);
    }

    //############################################################################

    public int countOrders2(int n) {
        long[][] dp = new long[n + 1][n + 1];

        for (int unpicked = 0; unpicked <= n; unpicked++) {
            for (int undelivered = unpicked; undelivered <= n; undelivered++) {
                // If all orders are picked and delivered then,
                // for remaining '0' orders we have only one way.
                if (unpicked == 0 && undelivered == 0) {
                    dp[unpicked][undelivered] = 1;
                    continue;
                }

                // There are some unpicked elements left.
                // We have choice to pick any one of those orders.
                if (unpicked > 0) {
                    dp[unpicked][undelivered] += unpicked * dp[unpicked - 1][undelivered];
                }
                dp[unpicked][undelivered] %= MOD;

                // Number of deliveries done is less than picked orders.
                // We have choice to deliver any one of (undelivered - unpicked) orders.
                if (undelivered > unpicked) {
                    dp[unpicked][undelivered] += (undelivered - unpicked) * dp[unpicked][undelivered - 1];
                }
                dp[unpicked][undelivered] %= MOD;
            }
        }

        return (int)dp[n][n];
    }
}
