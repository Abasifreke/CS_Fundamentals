
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

      LinkedList<TreeNode> q = new LinkedList<>();
      List<Integer> result = new ArrayList<>();
        if(root == null) return result;
      q.offer(root);

      
      while(!q.isEmpty()){
        int levelSize = q.size();
        
        for(int i = 0; i < levelSize; i++){
          TreeNode curr = q.poll();
          
          if(i == 0) result.add(curr.val);

          if(curr.right != null){
            q.offer(curr.right);
          }
          
          if(curr.left != null){
            q.offer(curr.left);
          }

        }
      }
      
      return result;
      
    }
}