public class String_Functions {
    public static void main(String args[]) {
        System.out.println(isUnique("Yes"));
        System.out.println(isUnique("Yess"));
        System.out.println();
        System.out.println(checkPerm("Yess", "ssYe"));
        System.out.println(checkPerm("Yesa", "Yeas"));
        System.out.println();
        System.out.println(urlify("Mr John Smith    ", 13));
        System.out.println();
        System.out.println(palinPerm("Tact Coa"));
        System.out.println(palinPerm("Tacct Ccoa")); 
        System.out.println();
        System.out.println(strComp("pale", "ple"));
        System.out.println(strComp("pales", "pale"));
        System.out.println(strComp("pale", "bale"));
        System.out.println(strComp("pale", "bake"));
        
        System.out.println(stringComp("aaabccDDDaa"));//a3b1c2D3a2
        System.out.println(stringComp("aBcD"));//aBcD
        System.out.println(stringComp("aabb"));//a2b2


        int[][] m = {{0, 2, 3, 4}, {1, 9, 1, 9}, {1,2,2,3}};
        
        m= matrixzero(m);
        
        for (int i=0; i<m.length;i++){
        for(int j = 0; j<m[0].length;j++){
            System.out.print(m[i][j] + " ");
        }
        System.out.println();
        }

    }
    
	public static int[][] matrixzero(int[][] arr){
	    String x = "";
	    String y = "";
	    for (int i=0; i<arr.length;i++){
	        for(int j = 0; j<arr[0].length;j++){
	            if(arr[i][j]==0)
	                {
	                    x+=Integer.toString(i);
	                    y+=Integer.toString(j);
	                }
	        }
	    }
    
	    for(int i=0; i<arr.length;i++){
	        for(int j = 0; j<arr[0].length;j++){
	            if(x.contains(Integer.toString(i)) || y.contains(Integer.toString(j)) )
	            arr[i][j] =0;
	        }
	    }
	    
	    return arr;
	}
	
	public static String stringComp(String in){
	    char[] arr = in.toCharArray();
	    StringBuilder s = new StringBuilder();
	    char prev = arr[0];
	    int count=1;
	    boolean notSame = true;
	    for(int i =1; i<arr.length; i++){
	        if(prev==arr[i]){
	            count++;
	        }
	        if(prev!=arr[i] || i==arr.length-1){
	            if(count>1)notSame = false;
	            s.append(""+prev+count);
	            prev = arr[i];
	            count=1;
	        }
	    }
	    
	    if(notSame)return in;
	    else return s.toString();
	    
	}
    
    public static boolean palinPerm(String a){
        int[] arr = new int[128];
        a = a.toLowerCase();
        
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=' '){
                arr[a.charAt(i)]++;
            }
        }
        boolean odd = false;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=' ' && arr[a.charAt(i)]%2!=0){
                if(odd)
                return false;
                else
                odd = true;
            }
        }
            
        return true;
        
    }
    
    public static boolean strComp(String a, String b){
        if(b.length()-a.length()==1)
        {
            int j=0;
            boolean onereplaced = false;
            for(int i=0; i<a.length(); i++){
                if(a.charAt(i)!=b.charAt(j)){
                    if(onereplaced)return false;
                    else onereplaced = true;
                    i--;
                }
                j++;
            }
            return true;
        }
        else if(a.length()-b.length()==1)
        {
            int j=0;
            boolean onereplaced = false;
            for(int i=0; i<b.length(); i++){
                if(b.charAt(i)!=a.charAt(j)){
                    if(onereplaced)return false;
                    else onereplaced = true;
                    i=i-1;
                }
                j++;
            }
            return true;
        }
        else if(a.length()==b.length())
        {
            boolean onereplaced = false;
            for(int i=0; i<a.length(); i++){
                if(a.charAt(i)!=b.charAt(i)){
                    if(onereplaced)return false;
                    else onereplaced = true;
                }
            }
            return true;
        }
        return false;
    }
    
    public static String urlify(String a, int length){
        char[] arr = a.toCharArray();
        
        char[] result = new char[arr.length];
        
        int i=0;
        int j=0;
        while(j<length){
            if(arr[j]!=' '){
                result[i]=arr[j];
                i++;
            }
            else{
                result[i]='%';
                result[i+1]='2';
                result[i+2]='0';
                i+=3;
            }
            j++;
        }
        
        return new String(result);
    }
    
    public static int add(int a, int b) { return a+b;}
    
    public static boolean isUnique(String a){
        char[] arr = a.toCharArray();
        
        for(int i =0; i<arr.length;i++){
            for(int j= i+1; j<arr.length; j++){
                if(arr[i]==arr[j])   return false;
            }
            
        }
        return true;
    }
    
    public static boolean checkPerm(String a, String b){
        if(a.length()!=b.length()) return false;
        int[] checker = new int[128];
        for(int i=0; i<a.length(); i++){
            checker[a.charAt(i)]++;
        }
        
        for(int i=0; i<b.length(); i++){
            checker[b.charAt(i)]--;
            if(checker[b.charAt(i)]<0){
                return false;
            }
        }
        
        return true;
    }
}
