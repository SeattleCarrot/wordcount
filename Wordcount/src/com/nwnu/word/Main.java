package com.nwnu.word;

import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner; 
import java.util.TreeMap;
import java.io.File;
import java.io.FileWriter;
import java.util.Map.Entry;

public class Main { 
	
	static Scanner scanner = new Scanner(System.in);
	static Map<String,Integer> hashMap = new LinkedHashMap<String, Integer>(); 
    @SuppressWarnings("resource")
	public static void main(String[] args)throws IOException { 
    	
    	//��ȡҪ������ļ�
    	System.out.println("�������ļ���:");
    	String src = scanner.next();
		BufferedReader message = new BufferedReader(new FileReader(src));
        //�����Ƶ
    	Map<String, Integer> treeMap = new TreeMap<String, Integer>();
        String value= message.readLine();
        while (value != null) {
           	String[] words = value.split("[^a-zA-Z]"); //������ʽ���������
           	for (int i = 0; i < words.length; i++) {   		
           		String key = words[i].toLowerCase(); //��дת��Сд
              	if (key.length() > 0) {
              		if (!treeMap.containsKey(key)) {
               			treeMap.put(key, 1);
               		} 
               		else { 
              			int k = treeMap.get(key)+1;// ������ǵ�һ�γ��֣��Ͱ�kֵ++
               			treeMap.put(key, k);
               		}
              	}
           	} 
           	value = message.readLine();
        }
        System.out.println("��ѡ������ִ�еĹ���");
        System.out.println("1:��ʾ��ѯ�ĵ��ʴ�Ƶ");
        System.out.println("2:�����Ƶ��ߵ�ǰN������");
        System.out.println("3:������ʼ���Ƶ��result.txt");
        System.out.println("0:�˳�");
        int w= scanner.nextInt();  
        while(w!=0){
        	switch(w){
        		case 1:
        				word(treeMap);
            	        break;
        		case 2:
                    	print(treeMap);
            	        break;
        		case 3:
                    	Write(treeMap);
            	        break;
                }
                System.out.println("��ѡ��ִ�еĹ��ܣ�");
                w= scanner.nextInt();  
            }
        }    
    
    //��ʾ��Ƶ
    public static void word(Map<String, Integer> map){
        
    	System.out.println("��������Ҫ��ѯ�ĵ��� :");
        scanner.nextLine();
        String string = scanner.nextLine();		
        String[] word= string.split("/");			
        float sum;
        for(int i = 0; i < word.length; i++) {
        	for(Map.Entry<String,Integer> w : map.entrySet()) { 
        		//int count=w.getValue();      			
        		if(word[i].equals(w.getKey()))
        		{  
        			System.out.println("����"+w.getKey() + "����" + w.getValue()+"��");
        			sum=(float)(w.getValue())/50; 
        			for(int j = 0;j < sum; j++){
        				System.out.print("#");
        			}
        			System.out.println();
        		}  
        	} 
        }
    }

    //���ǰn�����ʺ�����������״ͼ
    public static void print(Map<String, Integer> map) {  
    	  
    	wordcount rs = new wordcount();
    	  hashMap = rs.sort(map,2);
    	  System.out.println("������鿴�������еĵ��ʸ���n��");
          int n = scanner.nextInt();
          for(Entry<String,Integer> w : hashMap.entrySet()) {  
              System.out.println("����"+w.getKey() + "�����г���" + w.getValue() + "��");  
              n--;
              for(int i = 0; i < w.getValue(); i++) {
            	  System.out.print("��"+ "");
              }
              System.out.println();
              if(n <= 0)	
              	break;
          } 
          System.out.println();
        }  
      
    //����д��result.txt
    public static void Write(Map<String, Integer> map)throws IOException {  
    	  wordcount rs = new wordcount();
    	  hashMap = rs.sort(map, 3);
          File file = new File("result.txt");
          FileWriter f = new FileWriter(file.getAbsoluteFile());
          for(Entry<String,Integer> w: hashMap.entrySet()) {
        	  f.write(w.getKey() + ""+ "������:" + w.getValue() + "��                                                       ");
          }
          f.close();
          System.out.println("�Ѿ����浽�ĵ��У��뵽�ļ��м�飡");
      }  
}
