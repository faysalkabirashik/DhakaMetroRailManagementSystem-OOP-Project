/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import java.io.Serializable;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Faysal Kabir Ashik
 */
public class AddressLists implements Serializable {
    
    private static List<String> countries = new ArrayList<>();
    private static List<String> bdCities = new ArrayList<>();
    private static List<String> bdDistricts = new ArrayList<>();  
        
    private static  List<String> bdDivisions = new ArrayList<>(Arrays.asList(
                                "Dhaka", "Mymensingh", "Rajshahi", "Rangpur", 
                                 "Sylhet", "Khulna", "Chittagong", "Barisal")
                                );  

    private static Map<String, List<String>> mapDhaka = Stream.of(
            new SimpleEntry<>("Dhaka", Arrays.asList("Dhamrai", "Dohar", "Keraniganj", "Nawabganj", "Savar", "Tejgaon Circle")), 
            new SimpleEntry<>("Faridpur", Arrays.asList("Alfadanga", "Bhanga", "Boalmari", "Charbhadrasan", "Faridpur Sadar", "Madhukhali", "Nagarkanda", "Sadarpur", "Saltha" )),
            new SimpleEntry<>("Gazipur", Arrays.asList("Gazipur Sadar", "Kaliakair", "Kaliganj", "Kapasia", "Sreepur"))  ,
            new SimpleEntry<>("Gopalganj", Arrays.asList("Gopalganj Sadar", "Kashiani", "Kotalipara", "Muksudpur", "Tungipara"))  ,
            new SimpleEntry<>("Kishoreganj", Arrays.asList("Austagram", "Bajitpur", "Bhairab", "Hossainpur", "Itna", "Karimganj", "Katiadi", "Kishoreganj Sadar", "Kuliarchar", "Mithamain", "Nikli", "Pakundia")),
            new SimpleEntry<>("Madaripur", Arrays.asList("Rajoir", "Madaripur Sadar", "Kalkini", "Shibchar")),
            new SimpleEntry<>("Manikganj", Arrays.asList("Daulatpur", "Ghior", "Harirampur", "Manikgonj Sadar", "Saturia", "Shivalaya", "Singair")),  
  
            new SimpleEntry<>("Munshiganj", Arrays.asList("Gazaria", "Lohajang", "Munshiganj Sadar", "Sirajdikhan", "Sreenagar", "Tongibari")),
            new SimpleEntry<>("Narayanganj", Arrays.asList("Araihazar", "Bandar", "Narayanganj Sadar", "Rupganj", "Sonargaon")),
            new SimpleEntry<>("Narsingdi", Arrays.asList("Narsingdi Sadar", "Belabo", "Monohardi", "Palash", "Raipura", "Shibpur")),
            new SimpleEntry<>("Rajbari", Arrays.asList("Baliakandi", "Goalandaghat", "Pangsha", "Rajbari Sadar", "Kalukhali")),
            new SimpleEntry<>("Shariatpur", Arrays.asList("Bhedarganj", "Damudya", "Gosairhat", "Naria", "Shariatpur Sadar", "Zajira", "Shakhipur")),
            new SimpleEntry<>("Tangail", Arrays.asList("Gopalpur", "Basail", "Bhuapur", "Delduar", "Ghatail", "Kalihati", "Madhupur", "Mirzapur", "Nagarpur", "Sakhipur", "Dhanbari", "Tangail Sadar"))            
                                                                )
            .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));
      
      
    private static Map<String, List<String>> mapMymensingh = Stream.of(
            
            new SimpleEntry<>("Jamalpur", Arrays.asList("Baksiganj", "Dewanganj", "Islampur", "Jamalpur Sadar", "Madarganj", "Melandaha", "Sarishabari")),
            new SimpleEntry<>("Mymensingh", Arrays.asList("Trishal", "Dhobaura", "Fulbaria", "Gaffargaon", "Gauripur", "Haluaghat", "Ishwarganj", "Mymensingh Sadar", "Muktagachha", "Nandail", "Phulpur", "Bhaluka", "Tara Khanda")),
            new SimpleEntry<>("Netrakona", Arrays.asList("Atpara", "Barhatta", "Durgapur", "Khaliajuri", "Kalmakanda", "Kendua", "Madan", "Mohanganj", "Netrokona Sadar", "Purbadhala")),
            new SimpleEntry<>("Sherpur", Arrays.asList("Jhenaigati", "Nakla", "Nalitabari", "Sherpur Sadar", "Sreebardi"))
                                                                )
            .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));
               
    
    private static Map<String, List<String>> mapRajshahi = Stream.of(
                new SimpleEntry<>("Bogra", Arrays.asList("Adamdighi", "Bogura Sadar", "Dhunat", "Dhupchanchia", "Gabtali", "Kahaloo", "Nandigram", "Sariakandi", "Shajahanpur", "Sherpur", "Shibganj", "Sonatola")),
                new SimpleEntry<>("Chapainawabganj", Arrays.asList("Bholahat", "Gomastapur", "Nachole", "Nawabganj Sadar", "Shibganj")),  
                new SimpleEntry<>("Joypurhat", Arrays.asList("Akkelpur", "Joypurhat Sadar", "Kalai", "Khetlal", "Panchbibi")),
                new SimpleEntry<>("Naogaon", Arrays.asList("Atrai", "Badalgachhi", "Manda", "Dhamoirhat", "Mohadevpur", "Naogaon Sadar", "Niamatpur", "Patnitala", "Porsha", "Raninagar", "Sapahar")),
                new SimpleEntry<>("Natore", Arrays.asList("Bagatipara", "Baraigram", "Gurudaspur", "Lalpur", "Natore Sadar", "Singra", "Naldanga")),
                new SimpleEntry<>("Pabna", Arrays.asList("Atgharia", "Bera", "Bhangura", "Chatmohar", "Faridpur", "Ishwardi", "Pabna Sadar", "Santhia", "Sujanagar")),
                new SimpleEntry<>("Rajshahi", Arrays.asList("Bagha", "Bagmara", "Charghat", "Durgapur", "Godagari", "Mohanpur", "Paba", "Puthia", "Tanore")),
                new SimpleEntry<>("Sirajganj", Arrays.asList("Belkuchi", "Chauhali", "Kamarkhanda", "Kazipur", "Raiganj", "Shahjadpur", "Sirajganj Sadar", "Tarash", "Ullahpara"))
                )
            .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));

    private static Map<String, List<String>> mapRangpur = Stream.of(
                new SimpleEntry<>("Dinajpur", Arrays.asList("Birampur", "Birganj", "Biral", "Bochaganj", "Chirirbandar", "Phulbari", "Ghoraghat", "Hakimpur", "Kaharole", "Khansama", "Dinajpur Sadar", "Nawabganj", "Parbatipur")),  
                new SimpleEntry<>("Gaibandha", Arrays.asList("Phulchhari", "Gaibandha Sadar", "Gobindaganj", "Palashbari", "Sadullapur", "Sughatta", "Sundarganj")),  
                new SimpleEntry<>("Kurigram", Arrays.asList("Bhurungamari", "Char Rajibpur", "Chilmari", "Phulbari", "Kurigram Sadar", "Nageshwari", "Rajarhat", "Raomari", "Ulipur")),  
                new SimpleEntry<>("Lalmonirhat", Arrays.asList("Aditmari", "Hatibandha", "Kaliganj", "Lalmonirhat Sadar", "Patgram")),  
                new SimpleEntry<>("Nilphamari", Arrays.asList("Dimla", "Domar", "Jaldhaka", "Kishoreganj", "Nilphamari Sadar", "Saidpur")),  
                new SimpleEntry<>("Panchagarh", Arrays.asList("Atwari", "Boda", "Debiganj", "Panchagarh Sadar", "Tetulia")),  
                new SimpleEntry<>("Rangpur", Arrays.asList("Badarganj", "Gangachhara", "Kaunia", "Rangpur Sadar", "Mithapukur", "Pirgachha", "Pirganj", "Taraganj")),  

                new SimpleEntry<>("Thakurgaon", Arrays.asList("Baliadangi", "Haripur", "Pirganj", "Ranisankail", "Thakurgaon Sadar"))
                )
            .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));
 

    private static Map<String, List<String>> mapSylhet = Stream.of(
                new SimpleEntry<>("Habiganj", Arrays.asList("Ajmiriganj", "Bahubal", "Baniyachong", "Chunarughat", "Habiganj Sadar", "Lakhai", "Madhabpur", "Nabiganj", "Sayestaganj")),  
                new SimpleEntry<>("Moulvibazar", Arrays.asList("Barlekha", "Juri", "Kamalganj", "Kulaura", "Moulvibazar Sadar", "Rajnagar", "Sreemangal")),  
                new SimpleEntry<>("Sunamganj", Arrays.asList("Bishwamvarpur", "Chhatak", "Dakshin Sunamganj", "Derai", "Dharamapasha", "Dowarabazar", "Jagannathpur", "Jamalganj", "Sullah", "Sunamganj Sadar", "Tahirpur")),  
                new SimpleEntry<>("Sylhet", Arrays.asList("Balaganj", "Beanibazar", "Bishwanath", "Companigonj", "Dakshin Surma", "Fenchuganj", "Golapganj", "Gowainghat", "Jaintiapur", "Kanaighat", "Osmani Nagar", "Sylhet Sadar", "Zakiganj"))
                )
            .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));

        
    private static Map<String, List<String>> mapKhulna = Stream.of(
                new SimpleEntry<>("Bagerhat", Arrays.asList("Bagerhat Sadar", "Chitalmari", "Fakirhat", "Kachua", "Mollahat", "Mongla", "Morrelganj", "Rampal", "Sarankhola")),  
                new SimpleEntry<>("Chuadanga", Arrays.asList("Alamdanga", "Chuadanga Sadar", "Damurhuda", "Jibannagar")),  
                new SimpleEntry<>("Jessore", Arrays.asList("Abhaynagar", "Bagherpara", "Chaugachha", "Jhikargachha", "Keshabpur", "Jashore Sadar", "Manirampur", "Sharsha")),  
                new SimpleEntry<>("Jhenaidah", Arrays.asList("Harinakunda", "Jhenaidah Sadar", "Kaliganj", "Kotchandpur", "Maheshpur", "Shailkupa")),  
                new SimpleEntry<>("Khulna", Arrays.asList("Batiaghata", "Dacope", "Dumuria", "Dighalia", "Koyra", "Paikgachha", "Phultala", "Rupsha", "Terokhada", "Daulatpur Thana", "Khalishpur Thana", "Khan Jahan Ali Thana", "Kotwali Thana", "Sonadanga Thana", "Harintana Thana")),  
                new SimpleEntry<>("Kushtia", Arrays.asList("Bheramara", "Daulatpur", "Khoksa", "Kumarkhali", "Kushtia Sadar", "Mirpur")),  
                new SimpleEntry<>("Magura", Arrays.asList("Magura Sadar", "Mohammadpur", "Shalikha", "Sreepur")),  
                new SimpleEntry<>("Meherpur", Arrays.asList("Gangni", "Meherpur Sadar", "Mujibnagar")),  
                new SimpleEntry<>("Narail", Arrays.asList("Kalia", "Lohagara", "Narail Sadar", "Naragati Thana")),
                new SimpleEntry<>("Satkhira", Arrays.asList("Assasuni", "Debhata", "Kalaroa", "Kaliganj", "Satkhira Sadar", "Shyamnagar", "Tala"))
                )
            .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));

              
    private static Map<String, List<String>> mapChittagong = Stream.of(
                new SimpleEntry<>("Bandarban", Arrays.asList("Ali Kadam", "Bandarban Sadar", "Lama", "Naikhongchhari", "Rowangchhari", "Ruma", "Thanchi")),  
                new SimpleEntry<>("Brahmanbaria", Arrays.asList("Akhaura", "Bancharampur", "Brahmanbaria Sadar", "Kasba", "Nabinagar", "Nasirnagar", "Sarail", "Ashuganj", "Bijoynagar")),  
                new SimpleEntry<>("Chandpur", Arrays.asList("Chandpur Sadar", "Faridganj", "Haimchar", "Haziganj", "Kachua", "Matlab Dakshin", "Matlab Uttar", "Shahrasti")),  
                new SimpleEntry<>("Chittagong", Arrays.asList("Anwara", "Banshkhali", "Boalkhali", "Chandanaish", "Fatikchhari", "Hathazari", "Karnaphuli", "Lohagara", "Mirsharai", "Patiya", "Rangunia", "Raozan", "Sandwip", "Satkania", "Sitakunda", "Bandar Thana", "Chandgaon Thana", "Double Mooring Thana", "Kotwali Thana", "Pahartali Thana", "Panchlaish Thana", "Bhujpur Thana")),  
                new SimpleEntry<>("Comilla", Arrays.asList("Barura", "Brahmanpara", "Burichang", "Chandina", "Chauddagram", "Daudkandi", "Debidwar", "Homna", "Laksam", "Muradnagar", "Nangalkot", "Cumilla Adarsha Sadar", "Meghna", "Titas", "Monohargonj", "Cumilla Sadar Dakshin")),  
                new SimpleEntry<>("Cox's Bazar", Arrays.asList("Chakaria", "Cox's Bazar Sadar", "Kutubdia", "Maheshkhali", "Ramu", "Teknaf", "Ukhia", "Pekua")),  
                new SimpleEntry<>("Feni", Arrays.asList("Chhagalnaiya", "Daganbhuiyan", "Feni Sadar", "Parshuram", "Sonagazi", "Fulgazi")),  
                new SimpleEntry<>("Khagrachhari", Arrays.asList("Dighinala", "Khagrachhari", "Lakshmichhari", "Mahalchhari", "Manikchhari", "Matiranga", "Panchhari", "Ramgarh")),  
                new SimpleEntry<>("Lakshmipur", Arrays.asList("Lakshmipur Sadar", "Raipur", "Ramganj", "Ramgati", "Kamalnagar")),
                new SimpleEntry<>("Noakhali", Arrays.asList("Begumganj", "Noakhali Sadar", "Chatkhil", "Companiganj", "Hatiya", "Senbagh", "Sonaimuri", "Subarnachar", "Kabirhat")),
                new SimpleEntry<>("Rangamati", Arrays.asList("Bagaichhari", "Barkal", "Kawkhali (Betbunia)", "Belaichhari", "Kaptai", "Juraichhari", "Langadu", "Naniyachar", "Rajasthali", "Rangamati Sadar"))
                )
            .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));
        
        
    private static Map<String, List<String>> mapBarisal = Stream.of(
                new SimpleEntry<>("Barguna", Arrays.asList("Amtali", "Bamna", "Barguna Sadar", "Betagi", "Patharghata", "Taltali")),  
                new SimpleEntry<>("Barisal", Arrays.asList("Agailjhara", "Babuganj", "Bakerganj", "Banaripara", "Gaurnadi", "Hizla", "Barishal Sadar", "Mehendiganj", "Muladi", "Wazirpur")),  
                new SimpleEntry<>("Bhola", Arrays.asList("Bhola Sadar", "Burhanuddin", "Char Fasson", "Daulatkhan", "Lalmohan", "Manpura", "Tazumuddin")),  
                new SimpleEntry<>("Jhalokati", Arrays.asList("Jhalokati Sadar", "Kathalia", "Nalchity", "Rajapur")),  
                new SimpleEntry<>("Patuakhali", Arrays.asList("Bauphal", "Dashmina", "Galachipa", "Kalapara", "Mirzaganj", "Patuakhali Sadar", "Rangabali", "Dumki")),  
                new SimpleEntry<>("Pirojpur", Arrays.asList("Bhandaria", "Kawkhali", "Mathbaria", "Nazirpur", "Pirojpur Sadar", "Nesarabad (Swarupkati)", "Zianagar"))
                )
            .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));        
        
        
    

        ///////////// Methods /////////////////////
    private static List<String> getInitialCountries() {
        countries.add("Afghanistan");
        countries.add("Albania");
        countries.add("Algeria");
        countries.add("Andorra");
        countries.add("Angola");
        countries.add("Antigua and Barbuda");
        countries.add("Argentina");
        countries.add("Armenia");
        countries.add("Australia");
        countries.add("Austria");
        countries.add("Azerbaijan");
        countries.add("Bahamas");
        countries.add("Bahrain");
        countries.add("Bangladesh");
        countries.add("Barbados");
        countries.add("Belarus");
        countries.add("Belgium");
        countries.add("Belize");
        countries.add("Benin");
        countries.add("Bhutan");
        countries.add("Bolivia");
        countries.add("Bosnia and Herzegovina");
        countries.add("Botswana");
        countries.add("Brazil");
        countries.add("Brunei");
        countries.add("Bulgaria");
        countries.add("Burkina Faso");
        countries.add("Burundi");
        countries.add("Cabo Verde");
        countries.add("Cambodia");
        countries.add("Cameroon");
        countries.add("Canada");
        countries.add("Central African Republic (CAR)");
        countries.add("Chad");
        countries.add("Chile");
        countries.add("China");
        countries.add("Colombia");
        countries.add("Comoros");
        countries.add("Democratic Republic of the Congo");
        countries.add("Republic of the Congo");
        countries.add("Costa Rica");
        countries.add("Cote d'Ivoire");
        countries.add("Croatia");
        countries.add("Cuba");
        countries.add("Cyprus");
        countries.add("Czech Republic");
        countries.add("Denmark");
        countries.add("Djibouti");
        countries.add("Dominica");
        countries.add("Dominican Republic");
        countries.add("Ecuador");
        countries.add("Egypt");
        countries.add("El Salvador");
        countries.add("Equatorial Guinea");
        countries.add("Eritrea");
        countries.add("Estonia");
        countries.add("Ethiopia");
        countries.add("Fiji");
        countries.add("Finland");
        countries.add("France");
        countries.add("Gabon");
        countries.add("Gambia");
        countries.add("Georgia");
        countries.add("Germany");
        countries.add("Ghana");
        countries.add("Greece");
        countries.add("Grenada");
        countries.add("Guatemala");
        countries.add("Guinea");
        countries.add("Guinea-Bissau");
        countries.add("Guyana");
        countries.add("Haiti");
        countries.add("Honduras");
        countries.add("Hungary");
        countries.add("Iceland");
        countries.add("India");
        countries.add("Indonesia");
        countries.add("Iran");
        countries.add("Iraq");
        countries.add("Ireland");
        countries.add("Italy");
        countries.add("Jamaica");
        countries.add("Japan");
        countries.add("Jordan");
        countries.add("Kazakhstan");
        countries.add("Kenya");
        countries.add("Kiribati");
        countries.add("Kosovo");
        countries.add("Kuwait");
        countries.add("Kyrgyzstan");
        countries.add("Laos");
        countries.add("Latvia");
        countries.add("Lebanon");
        countries.add("Lesotho");
        countries.add("Liberia");
        countries.add("Libya");
        countries.add("Liechtenstein");
        countries.add("Lithuania");
        countries.add("Luxembourg");
        countries.add("Macedonia (FYROM)");
        countries.add("Madagascar");
        countries.add("Malawi");
        countries.add("Malaysia");
        countries.add("Maldives");
        countries.add("Mali");
        countries.add("Malta");
        countries.add("Marshall Islands");
        countries.add("Mauritania");
        countries.add("Mauritius");
        countries.add("Mexico");
        countries.add("Micronesia");
        countries.add("Moldova");
        countries.add("Monaco");
        countries.add("Mongolia");
        countries.add("Montenegro");
        countries.add("Morocco");
        countries.add("Mozambique");
        countries.add("Myanmar (Burma)");
        countries.add("Namibia");
        countries.add("Nauru");
        countries.add("Nepal");
        countries.add("Netherlands");
        countries.add("New Zealand");
        countries.add("Nicaragua");
        countries.add("Niger");
        countries.add("Nigeria");
        countries.add("North Korea");
        countries.add("Norway");
        countries.add("Oman");
        countries.add("Pakistan");
        countries.add("Palau");
        countries.add("Palestine");
        countries.add("Panama");
        countries.add("Papua New Guinea");
        countries.add("Paraguay");
        countries.add("Peru");
        countries.add("Philippines");
        countries.add("Poland");
        countries.add("Portugal");
        countries.add("Qatar");
        countries.add("Romania");
        countries.add("Russia");
        countries.add("Rwanda");
        countries.add("Saint Kitts and Nevis");
        countries.add("Saint Lucia");
        countries.add("Saint Vincent and the Grenadines");
        countries.add("Samoa");
        countries.add("San Marino");
        countries.add("Sao Tome and Principe");
        countries.add("Saudi Arabia");
        countries.add("Senegal");
        countries.add("Serbia");
        countries.add("Seychelles");
        countries.add("Sierra Leone");
        countries.add("Singapore");
        countries.add("Slovakia");
        countries.add("Slovenia");
        countries.add("Solomon Islands");
        countries.add("Somalia");
        countries.add("South Africa");
        countries.add("South Korea");
        countries.add("South Sudan");
        countries.add("Spain");
        countries.add("Sri Lanka");
        countries.add("Sudan");
        countries.add("Suriname");
        countries.add("Swaziland");
        countries.add("Sweden");
        countries.add("Switzerland");
        countries.add("Syria");
        countries.add("Taiwan");
        countries.add("Tajikistan");
        countries.add("Tanzania");
        countries.add("Thailand");
        countries.add("Timor-Leste");
        countries.add("Togo");
        countries.add("Tonga");
        countries.add("Trinidad and Tobago");
        countries.add("Tunisia");
        countries.add("Turkey");
        countries.add("Turkmenistan");
        countries.add("Tuvalu");
        countries.add("Uganda");
        countries.add("Ukraine");
        countries.add("United Arab Emirates (UAE)");
        countries.add("United Kingdom (UK)");
        countries.add("United States of America (USA)");
        countries.add("Uruguay");
        countries.add("Uzbekistan");
        countries.add("Vanuatu");
        countries.add("Vatican City (Holy See)");
        countries.add("Venezuela");
        countries.add("Vietnam");
        countries.add("Yemen");
        countries.add("Zambia");
        countries.add("Zimbabwe");
        return countries;
        }

    public static List<String> getCountries() 
    {
        if (AddressLists.countries.isEmpty())
        {
            countries = AddressLists.getInitialCountries();
            return countries;
        }
        else{
            return countries;
        }
        
    }

    public static List<String> getBdDivisions() 
    {
        return bdDivisions;
    }

    
    public static List<String> getAllInitialDistricts() 
        {
        // Todo
        return bdDistricts;
        }
    
    public static List<String> getBdDistricts() 
        {
        return bdDistricts;
        }
    public static ObservableList<String> getBdDistricts(String divisionName) 
            
        {
            ObservableList<String> obsList = FXCollections.observableArrayList();
            try{

                if (null == divisionName)
                {
                    AlertGeneration.errorAlert("Not Found!", "Please give the division correctly!");
                }

                else switch (divisionName) {
                    case "Dhaka":
                        obsList =  FXCollections.observableArrayList(AddressLists.getMapDhaka().keySet());
                        break;
                    case "Mymensingh":
                        obsList =  FXCollections.observableArrayList(AddressLists.getMapMymensingh().keySet());
                        break;
                    case "Rajshahi":
                        obsList =  FXCollections.observableArrayList(AddressLists.getMapRajshahi().keySet());
                        break;
                    case "Rangpur":
                        obsList =  FXCollections.observableArrayList(AddressLists.getMapRangpur().keySet());
                        break;
                    case "Sylhet":
                        obsList =  FXCollections.observableArrayList(AddressLists.getMapSylhet().keySet());
                        break;
                    case "Khulna":
                        obsList =  FXCollections.observableArrayList(AddressLists.getMapKhulna().keySet());
                        break;
                    case "Chittagong":
                        obsList =  FXCollections.observableArrayList(AddressLists.getMapChittagong().keySet());
                        break;
                    case "Barisal":
                        obsList =  FXCollections.observableArrayList(AddressLists.getMapBarisal().keySet());
                        break;
                    default:
                        AlertGeneration.errorAlert("Not Found!", "Please give the division correctly!");
                        break;
                }
            }catch(Exception e)
            {
                AlertGeneration.errorAlert(e);
            }
        
            return obsList;
        }
    
    public static void setCountries(List<String> countries) 
        {
        AddressLists.countries = countries;
        }
    
    public static void addCountries(List<String> list)
        {
        countries.addAll(list);
        }
    
      //// To Do ////
/*
    public static List<String> getBdCities() {
        // todo
        return bdCities;
        }

    public static void setBdCities(List<String> bdCities) {
        AddressLists.bdCities = bdCities;
        }



    public static void setBdDistricts(List<String> bdDistricts) {
        AddressLists.bdDistricts = bdDistricts;
        }



    public static void setBdDivisions(List<String> bdDivisions) {
        AddressLists.bdDivisions = bdDivisions;
    }
    
*/
    
    public static Map<String, List<String>> getMap(String divisionName){
    {
     try{

         if (null == divisionName)
         {
             AlertGeneration.errorAlert("Not Found!", "Please give the division correctly!");
         }
         else  if ("Dhaka".equals(divisionName)) 
         {

                 return getMapDhaka(); 
         }
         else  if ("Mymensingh".equals(divisionName)){
                 return  getMapMymensingh();}

         else  if ("Rajshahi".equals(divisionName)){
                 return  getMapRajshahi();}
         else  if ("Rangpur".equals(divisionName)){
                 return  getMapRangpur();}
         else if ("Sylhet".equals(divisionName)){
                 return  getMapSylhet();}
         else if ("Khulna".equals(divisionName)){
                 return  getMapKhulna();}
         else if ("Chittagong".equals(divisionName)){
                 return  getMapChittagong();}
         else if ("Barisal".equals(divisionName)){
                 return  getMapBarisal();}
          
//                 break;

//         else switch (divisionName) {
//             case "Dhaka":
//                 return getMapDhaka();
//
//             case "Mymensingh":
//                 return  getMapMymensingh();
//
//             case "Rajshahi":
//                 return  getMapRajshahi();
//             case "Rangpur":
//                 return  getMapRangpur();
//             case "Sylhet":
//                 return  getMapSylhet();
//             case "Khulna":
//                 return  getMapKhulna();
//             case "Chittagong":
//                 return  getMapChittagong();
//             case "Barisal":
//                 return  getMapBarisal();
//             default:
//                 AlertGeneration.errorAlert("Not Found!", "Please give the division correctly!");
//                 break;
//            }
        }catch(Exception e)
        {
            AlertGeneration.errorAlert(e);
        }

       }
       return null;
   }


    public static Map<String, List<String>> getMapDhaka() {
        return mapDhaka;
    }

    public static void setMapDhaka(Map<String, List<String>> mapDhaka) {
        AddressLists.mapDhaka = mapDhaka;
    }

    public static Map<String, List<String>> getMapMymensingh() {
        return mapMymensingh;
    }

    public static void setMapMymensingh(Map<String, List<String>> mapMymensingh) {
        AddressLists.mapMymensingh = mapMymensingh;
    }

    public static Map<String, List<String>> getMapRajshahi() {
        return mapRajshahi;
    }

    public static void setMapRajshahi(Map<String, List<String>> mapRajshahi) {
        AddressLists.mapRajshahi = mapRajshahi;
    }

    public static Map<String, List<String>> getMapRangpur() {
        return mapRangpur;
    }

    public static void setMapRangpur(Map<String, List<String>> mapRangpur) {
        AddressLists.mapRangpur = mapRangpur;
    }

    public static Map<String, List<String>> getMapSylhet() {
        return mapSylhet;
    }

    public static void setMapSylhet(Map<String, List<String>> mapSylhet) {
        AddressLists.mapSylhet = mapSylhet;
    }

    public static Map<String, List<String>> getMapKhulna() {
        return mapKhulna;
    }

    public static void setMapKhulna(Map<String, List<String>> mapKhulna) {
        AddressLists.mapKhulna = mapKhulna;
    }

    public static Map<String, List<String>> getMapChittagong() {
        return mapChittagong;
    }

    public static void setMapChittagong(Map<String, List<String>> mapChittagong) {
        AddressLists.mapChittagong = mapChittagong;
    }

    public static Map<String, List<String>> getMapBarisal() {
        return mapBarisal;
    }

    public static void setMapBarisal(Map<String, List<String>> mapBarisal) {
        AddressLists.mapBarisal = mapBarisal;
    }
        
        
        

    
}
