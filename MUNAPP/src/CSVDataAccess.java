
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

//what is the problem
//application number 6 sir and the problem is we are not getting sum sir
public class CSVDataAccess {
	private List<CSVUser> user1;
	public List<CSVUser> getMunDetails(){
	
		try {
			BufferedReader	fileReader = new BufferedReader(new FileReader("./App 6 MunExp.csv"));

			CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder<CSVUser>(fileReader)
					.withType(CSVUser.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();

			List<CSVUser> csvUsers = csvToBean.parse();
			user1 = csvUsers;

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user1;
	}//execute it
	
	public void yearwise(List<CSVUser> u,String year){
		System.out.println("Yearwise exp and rev in the year:"+year);
		int sumrev = 0;
		int sumexp = 0;

		for(CSVUser user: u){
			 System.out.print(user.getCategory()+" "+user.getYear()+" "+user.getRev()+" "+user.getExp()+"\n");
		 }
		
		
		 for(CSVUser user: u){
			 String y = user.getYear();
			if(year.equals(y) ){
				
				int r = Integer.parseInt(user.getRev());
				int e = Integer.parseInt(user.getExp());
				System.out.println(e);
				sumrev = sumrev + r;
				sumexp = sumexp + e;
				
			}
		}
		 System.out.println(sumrev);
		System.out.println(sumexp);
	}//execute it
	public void categorywise(List<CSVUser> u,String category){
		System.out.println("Categorywise exp and rev in category:"+category);
		int sumrev1 = 0;
		int sumexp1 = 0;
		  for(CSVUser user: u){
			String c = user.getCategory();
			if(category.equals(c)){
				
				int r = Integer.parseInt(user.getRev());
				int e = Integer.parseInt(user.getExp());
				sumrev1 = sumrev1 + r;
				sumexp1 = sumexp1 + e;	
			}
		 }
			System.out.println(sumrev1);
			System.out.println(sumexp1);
		}
}
