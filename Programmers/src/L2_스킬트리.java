
public class L2_스킬트리 {
	public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        int index = 0;
        String s;
        for(int i = 0; i < skill_trees.length; i++){
            index = 0;
            for(int j = 0; j < skill_trees[i].length(); j++){
                s = Character.toString(skill_trees[i].charAt(j));
                if(skill.contains(s)){
                    if(skill.indexOf(s) > index){
                        answer--;
                        break;   
                    }
                    else if(skill.indexOf(s) == index)
                        index++;
                }
            }
        }
        return answer;
    }
}
