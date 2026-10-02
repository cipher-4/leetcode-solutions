class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> m = new HashMap<>();
        for(String s : strs)
        {
            char [] arr = s.toCharArray();
            Arrays.sort(arr);
            String k = new String(arr);

            if(!m.containsKey(k))
            {
                m.put(k,new ArrayList<>());
            }
            m.get(k).add(s);
        }
        return new ArrayList<>(m.values());
    }
}