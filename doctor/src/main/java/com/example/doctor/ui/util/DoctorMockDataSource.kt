package com.example.doctor.ui.util

object DoctorMockDataSource {

    //Mock Data

    val singleItemList = listOfNotNull(
        "United Insurance",
        "Metlife",
        "American Family Insurance"

    )

    val mockResponse =
        "{\"firstName\":\"Mark\",\"lastName\":\"Chaney\",\"mobile\":\"990-444-6363\",\"emailId\":\"MarkChaney@gmail.com\",\"patientNumber\":\"4187359811\",\"dateOfBirth\":\"10 JANUARY 1990\",\"address\":\"2800 s king drive, Chicago, IL, 60616\",\"insuranceName\":\"United Health\",\"insuranceNumber\":\"900909456\",\"memberNumber\":\"0098767565\",\"insuranceList\":[\"UnitedHealth\",\"Cigna Health\",\"Anthem Inc\",\"Centene Corp\",\"Humana\",\"Health Care Service Corporation\",\"Kaiser Foundation \"],\"doctors\":[{\"suffix\":\"Dr\",\"firstName\":\"Rahul\",\"lastName\":\"Khare\",\"mobile\":\"990-639-8457\",\"specialist\":\"Internist\",\"clinicAddress\":\"2400 N Ashland Ave,Chicago,IL 60614\",\"emailId\":\"rahul.khare@gmail.com\",\"distance\":\"10.3mi\",\"imageURL\":\"\"},{\"suffix\":\"Dr\",\"firstName\":\"Emelita\",\"lastName\":\"co\",\"mobile\":\"990-456-9612\",\"specialist\":\"Primary Care\",\"clinicAddress\":\"137N Oak Park Ave, Oak Park, IL 60301\",\"emailId\":\"emelita.co@gmail.com\",\"distance\":\"0.9mi\",\"imageURL\":\"\"},{\"suffix\":\"Dr\",\"firstName\":\"kevin\",\"lastName\":\"Boblick\",\"mobile\":\"990-639-7432\",\"specialist\":\"Internist\",\"clinicAddress\":\"7005 W North Ave, Oak Park, IL 60302\",\"emailId\":\"kevin.Boblick@gmail.com\",\"distance\":\"3mi\",\"imageURL\":\"\"},{\"suffix\":\"Dr\",\"firstName\":\"Renu\",\"lastName\":\"Gupta\",\"mobile\":\"990-619-4433\",\"specialist\":\"Psychiatry\",\"clinicAddress\":\"Westbrrok corporate ctr,Westchester,IL 60154\",\"emailId\":\"renu.gupta@gmail.com\",\"distance\":\"30mi\",\"imageURL\":\"\"},{\"suffix\":\"Dr\",\"firstName\":\"Daniel\",\"lastName\":\"krauss\",\"mobile\":\"990-412-2791\",\"specialist\":\"cardiovascular\",\"clinicAddress\":\"2434 Wolf rd,Westchester,IL 60154\",\"emailId\":\"daniel.krauss@gmail.com\",\"distance\":\"4.6mi\",\"imageURL\":\"\"},{\"suffix\":\"Dr\",\"firstName\":\"George\",\"lastName\":\"Gibbs\",\"mobile\":\"990-477-7164\",\"specialist\":\"cardiovascular\",\"clinicAddress\":\"2434 Wolf rd,Westchester,IL 60154\",\"emailId\":\"geroge.gibbs@gmail.com\",\"distance\":\"18mi\",\"imageURL\":\"\"},{\"suffix\":\"Dr\",\"firstName\":\"Brent \",\"lastName\":\"Scott Rieger\",\"mobile\":\"990-456-1785\",\"specialist\":\"Primary Care\",\"clinicAddress\":\"1100 Lake st, Oak Park, IL 60301\",\"emailId\":\"brent.scott@gmail.com\",\"distance\":\"1.6mi\",\"imageURL\":\"\"}]}"
}
