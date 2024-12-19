
public class QueueYapisi {
	
	Node front;
	Node rear;
	int count;
	int size;
	public QueueYapisi(int size) {
		this.size = size;
		front = null;
		rear = null;
		count = 0;
	}
	
	
	void enQueue(char ch)
	{
		if( ! isFull())
		{
			Node eleman = new Node(ch);
			
			if (isEmpty()) 
			{
				front = eleman;
				rear = eleman;
				
			}
			else
			{
				rear.next = eleman;			
				rear = eleman;
			}
			count++;
		}
	}
	
	char deQueue()
	{
		if ( ! isEmpty()) {
			char ch = front.harf;
			front = front.next;
			count--;
			return ch;
		}
		else 
			return '+';
		
	}
	
	boolean isEmpty()
	{
		return count == 0;
		
	}
	
	boolean isFull()
	{
		return count == size;
	}
	
	
	

}
