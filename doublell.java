import java.util.Scanner;

class dnode{
    int data;
    dnode next;
    dnode prev;
    
    public dnode(int data,dnode next,dnode prev){
        this.data = data;
        this.next = next;
        this.prev = prev;

    }
 }

public class doublell {
    static dnode head = null;
    public static void main(String[] args) {
        
        listCreate();
        insert();
        display();
        delete();
        display();
    }
    static void listCreate(){
        dnode newNode,temp=null;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the no of nodes : ");
        int no = sc.nextInt();
        for (int i = 0; i < no; i++) {
            newNode = new dnode((i+1)*10,null,null);
            if(head == null){
                head = newNode;
                temp = newNode;
            }
            else{
                temp.next = newNode;
                newNode.prev=temp;
                temp = newNode;
            }
        }
    }
    static void display(){
        
        for(dnode temp = head;temp != null;temp = temp.next){
            System.out.print(temp.data + " -->");
        } 
        System.out.println(); 
    }
    static void insert(){
        System.out.println("Insertion : ");
        dnode temp = null,newNode;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Case : ");
        int swi = sc.nextInt();
        newNode = new dnode(100, null, null);
        switch(swi){
            case 1:
               newNode.next=head;
               newNode.next.prev = newNode;
               newNode.prev = null;
               head=newNode;
               break;
            case 2:
               System.out.print("Enter the position : ");
               int pos = sc.nextInt();
               int i = 1;
               for(temp = head;i <pos; temp = temp.next,i++);
               newNode.next=temp.next;
               temp.next.prev=newNode;
               temp.next = newNode;
               newNode.prev = temp;
               break;
            case 3:
               for(temp=head;temp.next != null;temp = temp.next);
               newNode.next=null;
               newNode.prev = temp;
               temp.next = newNode;
               break;
            
        }
    }
    static void delete(){
        System.out.println("Deletion : ");
        dnode temp = null;
         Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Case : ");
        int swi = sc.nextInt();
        switch (swi) {
            case 1:
                temp = head;
                head = head.next;
                temp.next = null;
                head.prev = null;
                break;
            case 2:
                System.out.print("Enter the position : ");
                int pos = sc.nextInt();
                int i = 1;
                for(temp = head; i < pos; temp=temp.next,i++);
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                break;
            case 3:
                for(temp = head;temp.next != null;temp = temp.next);
                temp.prev.next=null;
                temp.prev=null;
                break;
        }

    }
        
}
