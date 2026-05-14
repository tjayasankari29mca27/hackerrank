

  /* Enter your code here */
    if (Fireball *fb = dynamic_cast<Fireball*>(spell)) {
        fb->revealFirepower();
    } 
    else if (Frostbite *fs = dynamic_cast<Frostbite*>(spell)) {
        fs->revealFrostpower();
    } 
    else if (Waterbolt *wb = dynamic_cast<Waterbolt*>(spell)) {
        wb->revealWaterpower();
    } 
    else if (Thunderstorm *ts = dynamic_cast<Thunderstorm*>(spell)) {
        ts->revealThunderpower();
    } 
    else {
        // 2. If it's a generic spell, find the LCS
        string s = spell->revealScrollName();
        string j = SpellJournal::read();
        int m = s.length();
        int n = j.length();

        // DP table for Longest Common Subsequence
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));

        for (int i = 1; i <= m; i++) {
            for (int k = 1; k <= n; k++) {
                if (s[i - 1] == j[k - 1]) {
                    dp[i][k] = dp[i - 1][k - 1] + 1;
                } else {
                    dp[i][k] = max(dp[i - 1][k], dp[i][k - 1]);
                }
            }
        }
        cout << dp[m][n] << endl;
    }
