package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptimalChangePojo {
    /*
    {
        "penceSubmitted": 50122,
            "externalID" : "UUID_1",
            "pounds": {
        "50": 10,
                "20": 0,
                "10": 0,
                "5": 0,
                "2": 0,
                "1": 1
    },
        "pence": {
        "50": 0,
                "20": 1,
                "10": 0,
                "5": 0,
                "2": 1,
                "1": 0
    },
        "dateTime": "2022-04-30T10:56:59.1381145"
    }
}


     */


    private Integer penceSubmitted;
    private String externalID;
    private Map<String,Integer> pounds;
    private Map<String,Integer> pence;
    private String dateTime;

    public OptimalChangePojo() {
    }

    public Integer getPenceSubmitted() {
        return penceSubmitted;
    }

    public String getExternalID() {
        return externalID;
    }

    public Map<String, Integer> getPounds() {
        return pounds;
    }

    public Map<String, Integer> getPence() {
        return pence;
    }

    public void setPenceSubmitted(Integer penceSubmitted) {
        this.penceSubmitted = penceSubmitted;
    }

    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }

    public void setPounds(Map<String, Integer> pounds) {
        this.pounds = pounds;
    }

    public void setPence(Map<String, Integer> pence) {
        this.pence = pence;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;


    }

    public OptimalChangePojo(Integer penceSubmitted, String externalID, Map<String, Integer> pounds, Map<String, Integer> pence, String dateTime) {
        this.penceSubmitted = penceSubmitted;
        this.externalID = externalID;
        this.pounds = pounds;
        this.pence = pence;
        this.dateTime = dateTime;





    }
}
