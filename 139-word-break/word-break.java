class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
       boolean[] f = new boolean[s.length() + 1];
        HashSet<String> dict = new HashSet<>(wordDict);
    return dfs(s, dict, new HashSet<>());
}

private boolean dfs(String s, Set<String> wordDict, Set<String> checked) {
    if (s.isEmpty()) return true;
    if (checked.contains(s)) return false;
    checked.add(s);
    
    for (String w : wordDict) {
        if (s.startsWith(w) && dfs(s.substring(w.length()), wordDict, checked)) return true;
    }
    return false;
}
}