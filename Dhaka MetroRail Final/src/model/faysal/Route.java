
package model.faysal;

import java.util.List;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class Route {
    
    private int mrtLineNo;
    private String routeName;
    
    private List<Station> statinList;
   
    private Station startingStation;
    private Station destinationStaion; 

    public int getMrtLineNo() {
        return mrtLineNo;
    }

    public void setMrtLineNo(int mrtLineNo) {
        this.mrtLineNo = mrtLineNo;
    }

    public List<Station> getStatinList() {
        return statinList;
    }

    public void setStatinList(List<Station> statinList) {
        this.statinList = statinList;
    }

    public Station getStartingStation() {
        return startingStation;
    }

    public void setStartingStation(Station startingStation) {
        this.startingStation = startingStation;
    }

    public Station getDestinationStaion() {
        return destinationStaion;
    }

    public void setDestinationStaion(Station destinationStaion) {
        this.destinationStaion = destinationStaion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Route{");
        sb.append("mrtLineNo=").append(mrtLineNo);
        sb.append(", statinList=").append(statinList);
        sb.append(", startingStation=").append(startingStation);
        sb.append(", destinationStaion=").append(destinationStaion);
        sb.append('}');
        return sb.toString();
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Route(int mrtLineNo, String routeName, List<Station> statinList, Station startingStation, Station destinationStaion) {
        this.mrtLineNo = mrtLineNo;
        this.routeName = routeName;
        this.statinList = statinList;
        this.startingStation = startingStation;
        this.destinationStaion = destinationStaion;
    }



    
}
