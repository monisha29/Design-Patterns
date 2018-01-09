
public class StratergyPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConversionMode pdf = new PDFConversion();
		ConversionMode docx = new DOCXConversion();
		File demoA = new OfficeFiles();
		demoA.fileName = "helloWorld";
		demoA.displayDetails();
		demoA.chooseConverter(pdf);
		demoA.convert();
		demoA.chooseConverter(docx);
		demoA.convert();
		demoA.chooseConverter(pdf);
		demoA.convert();
//		demoA = new OfficeFiles();
//		demoA.convert();

	}
	
}
   abstract	class File
	{
		public String fileName ;
		public ConversionMode mode;
		public abstract void displayDetails();
		
		public void chooseConverter(ConversionMode mode)
		{
			this.mode = mode;
		}
		
		public void convert()
		{
			mode.convert();
		}
			
	}
	
	interface ConversionMode
	{
		public void convert();
	}
	
	
	class PDFConversion implements ConversionMode
	{
		public void convert()
		{
			System.out.println("Converted to .pdf");
		}
	}
	
	class DOCXConversion implements ConversionMode
	{
		public void convert()
		{
			System.out.println("Converted to .docx");
		}
	}
	
	
	class OfficeFiles extends File
	{
		public void displayDetails()
		{
			System.out.println("These are office files : " + super.fileName );
		}
	}
	
	class AccountFiles extends File
	{	
		public void displayDetails()
		{
			System.out.println("These are account files : " + super.fileName);
		}
	}
	
	


