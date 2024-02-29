package Testingpack;

public class DisplayVowels {
	
	
	public static void main(String[] args) {
		
		
		String str="Hello World welcome ";
		System.out.println(str.length());
		
		str=str.toLowerCase().replace(" ", "");
		
		int vowelscount=0;
		int consonanatscount=0;
		
		StringBuilder vowels=new StringBuilder();
		StringBuilder consonanats=new StringBuilder();
		
		for(int i=0;i<str.length();i++) {
			
			char ch=str.charAt(i);
			if(ch=='a'|| ch=='e' || ch=='i' ||ch=='o'|| ch=='u') {
				
				vowels.append(ch).append(" ");
				vowelscount++;
			}else {
				
				consonanats.append(ch).append(" ");
				consonanatscount++;
			}
		}
		for(int i=0;i<vowels.length();i++)
        {
            int count=0;
            for(int j=0;j<i;j++)
            {
                if(vowels.charAt(i)==vowels.charAt(j))
                {
                    count++;
                }
            }
            if (count==0)
            {
                System.out.println(vowels.charAt(i));
            }
        }
		System.out.println("Vowels count"+vowelscount);
		System.out.println("Vowels display=: "+vowels);
		System.out.println("consonanatscount count"+consonanatscount);
		System.out.println("consonanats display=: "+consonanats);
		
	}

}
