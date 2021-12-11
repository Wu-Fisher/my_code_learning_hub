class Solution653 {
    public int findTilt(TreeNode root) {
        if(root!=null)
        {
            return findTilt(root.left)+findTilt(root.right)+Math.abs(getSum(root.left)-getSum(root.right));
        }   
        else return 0;

    }
    public int getSum(TreeNode root)
    {
        if(root!=null)
        {
            return root.val+getSum(root.left)+getSum(root.right);
        }
        else
        return 0;
    }
}