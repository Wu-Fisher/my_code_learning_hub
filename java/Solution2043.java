class Solution2043 {
    class Bank {
        long[] v;

        public Bank(long[] balance) {
            v = balance;
        }

        boolean check(long account) {
            if (account <= 0 || account > v.length)
                return false;
            else
                return true;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (!check(account1) || !check(account2))
                return false;
            if (v[account1 - 1] < money) {
                return false;
            }
            v[account1 - 1] -= money;
            v[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (!check(account))
                return false;
            v[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (!check(account))
                return false;
            if (v[account - 1] < money) {
                return false;
            }
            v[account - 1] -= money;
            return true;
        }
    }

    /**
     * Your Bank object will be instantiated and called as such:
     * Bank obj = new Bank(balance);
     * boolean param_1 = obj.transfer(account1,account2,money);
     * boolean param_2 = obj.deposit(account,money);
     * boolean param_3 = obj.withdraw(account,money);
     */
}