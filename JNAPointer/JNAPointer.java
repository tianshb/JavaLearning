import com.sun.jna.*;
import com.sun.jna.ptr.*;

public class JNAPointer {

	/**
	 * @param args
	 */
	public interface CLib extends Library{
	
		public interface OpenFunc extends Callback{
			void invoke ( IntByReference p1);
			//void invoke(String filename , int i);
		}
		
		public class FunCallBack implements OpenFunc{
			@Override
			/*public void invoke(String filename , int i){
				System.out.println("callback called.");
				System.out.println(filename);
			}*/
			    public void invoke( IntByReference p1){
				
 				System.out.println(p1);
				System.out.println("callback called.");
			}
		}
		
		void init(OpenFunc openfunc);
		void swap( IntByReference p1 , IntByReference p2);
		void test();
	}
	
	public static void main(String[] args) {
	
		CLib lib =(CLib)Native.loadLibrary("JNALib", CLib.class);
		CLib lib2 = (CLib)Native.loadLibrary("swap",CLib.class);
		CLib.FunCallBack  func = new CLib.FunCallBack();
		IntByReference p1 = new IntByReference (3);
		IntByReference p2 = new IntByReference (5);
		lib.init( func);
	    lib2.swap(p1, p2);//Java called C++ pointer
		lib.test();//C++ callback java
	}
}
