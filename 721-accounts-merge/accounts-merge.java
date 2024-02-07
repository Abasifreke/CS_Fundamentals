class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Map<String, LinkedHashSet<><

        /*
            [["John","johnsmith@mail.com","john_newyork@mail.com"],
            ["John","johnsmith@mail.com","john00@mail.com"],
            ["Mary","mary@mail.com"],
            ["John","johnnybravo@mail.com"]]
        */

        Map<String, HashSet<String>> emailGraph = new HashMap<>();
        Set<String> emailSet = new HashSet<>();

        for(List<String> emails: accounts){
            for(int i = 1; i < emails.size(); i++){
                String email1 = emails.get(i);

                 for(int j = 1; j < emails.size(); j++){
                     String email2 = emails.get(j);
                    if(!email1.equals(email2)){
                        emailGraph.putIfAbsent(email1, new HashSet<>());
                        emailGraph.get(email1).add(email2);
                        emailSet.add(email1);
                    }
                }
            }
        }

        // System.out.println(emailGraph);
        // System.out.println(emailSet);

        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for(List<String> account: accounts){
            boolean isMerged = false;
            for(int i = 1; i < account.size(); i++){
                if(visited.contains(account.get(i))){
                    isMerged = true;
                    break;
                }
            }

            if(!isMerged){
                // start new list.
                List<String> accountList = new ArrayList<>();
                // accountList.add(account.get(0));
                DFS(emailGraph, account.get(1), accountList, visited);
                Collections.sort(accountList);
                accountList.addFirst(account.get(0));
                result.add(accountList);
            }
        }

        return result;
    }

    private void DFS(Map<String, HashSet<String>> emailGraph, String email, List<String> accountList, Set<String> visited){
        if(visited.contains(email)) return;

        visited.add(email);
        accountList.add(email);
        if(emailGraph.containsKey(email)){
            for(String nEmail: emailGraph.get(email)){
                DFS(emailGraph, nEmail, accountList, visited);
            }
        }
    }
}