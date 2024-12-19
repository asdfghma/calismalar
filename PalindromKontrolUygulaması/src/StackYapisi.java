
public class StackYapisi {
	
	Node top;
	int size;
	int count;
	public StackYapisi(int size) {
		this.size = size;
		count = 0;
		top = null;
	}
	
	
	void push(char ch)
	{
		if ( ! isFull()) {
			Node eleman = new Node(ch);
			
			if (isEmpty())
			{
				top = eleman;
				
			}
			else 
			{
				eleman.next = top;
				top = eleman;
			}
			count++;
		}
	}
	
	
	char pop()
	{
		if ( ! isEmpty()) {
			char harf = top.harf;
			top = top.next;
			count--;
			return harf;
		}
		else 
			return '-';
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
