package in.nareshit.raghu.util;

import in.nareshit.raghu.model.Student;

public interface StudentUtil {

	// no instance var or no association mapping reference
	// java-8 static method in interface

	public static void calculateDtls(Student s) {

		var fee = s.getStdFee();
		var disc = fee * 10 / 100.0f;
		var gst = fee * 12 / 100.0f;
		s.setStdDiscount(disc);
		s.setStdGst(gst);
	}
}
