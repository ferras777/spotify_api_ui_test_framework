package api;

import api.bodies.json.JsonData;
import api.bodies.track.TrackBody;
import api.requests.TrackRequests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static api.asserts.TrackApiAssertions.checkResponseRightTrackId;
import static api.asserts.TrackApiAssertions.checkResponseRightTrackName;
import static api.utils.Json.getTracksDataFromJson;

public class TrackTests {

    TrackRequests trackRequests = new TrackRequests();

    @DataProvider(parallel = true)
    public Object[][] tracks() throws FileNotFoundException {
        return getTracksDataFromJson(10);
    }

    @Epic(value = "Треки")
    @Feature(value = "Проверка треков через API")
    @Stories(value = {@Story(value = "Проверка имени трека"),
            @Story(value = "Проверка ID трека")})
    @Test(description = "Check right name and id of track", dataProvider = "tracks")
    public void checkRightNameOfTrack(JsonData jsonData) {
        TrackBody trackBody = trackRequests.getTrackBody(jsonData.getId());
        checkResponseRightTrackName(trackBody, jsonData);
        checkResponseRightTrackId(trackBody, jsonData);
    }
}
