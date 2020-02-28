package ca.uqtr.fitbit.controller;

import ca.uqtr.fitbit.dto.DeviceDto;
import ca.uqtr.fitbit.dto.Request;
import ca.uqtr.fitbit.dto.Response;
import ca.uqtr.fitbit.entity.fitbit.ActivitiesCalories;
import ca.uqtr.fitbit.entity.fitbit.ActivitiesSteps;
import ca.uqtr.fitbit.entity.fitbit.Activity;
import ca.uqtr.fitbit.service.activity.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class ActivityController {

    private ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping(value = "/activity/all")
    @ResponseBody
    public Response getActivitiesBetween2Dates(@RequestParam String date1, @RequestParam String date2,
                                               @RequestBody Request request) throws IOException, ParseException {
        DeviceDto deviceDto = (DeviceDto) request.getObject();
        return activityService.getActivitiesBetween2DatesFromApi(date1, date2, deviceDto);
    }

    @GetMapping(value = "/activity/steps/day/{date}/time/minute/1")
    @ResponseBody
    public Response getStepsOfDayPerMinute(@PathVariable String date, @RequestBody Request request) throws IOException, ParseException {
        DeviceDto deviceDto = (DeviceDto) request.getObject();
        return activityService.getStepsOfDayPerMinuteFromApi(date, deviceDto);
    }

    @GetMapping(value = "/activity/steps/day/{date}/time/{startTime}/{endTime}/minute/1")
    @ResponseBody
    public Response getStepsOfDayBetweenTwoTimePerMinute(@PathVariable String date,
                                                                                @PathVariable String startTime,
                                                                                @PathVariable String endTime, @RequestBody Request request) throws IOException {
        DeviceDto deviceDto = (DeviceDto) request.getObject();
        return activityService.getStepsOfDayBetweenTwoTimesPerMinuteFromApi(date, startTime, endTime, deviceDto);
    }

    @GetMapping(value = "/activity/calories/day/{date}/time/minute/1")
    @ResponseBody
    public Response getCaloriesOfDayPerMinute(@PathVariable String date, @RequestBody Request request) throws IOException, ParseException {
        DeviceDto deviceDto = (DeviceDto) request.getObject();
        return activityService.getCaloriesOfDayPerMinuteFromApi(date, deviceDto);
    }

    @GetMapping(value = "/activity/calories/day/{date}/time/{startTime}/{endTime}/minute/1")
    @ResponseBody
    public Response getCaloriesOfDayBetweenTwoTimePerMinute(@PathVariable String date,
                                                                                   @PathVariable String startTime,
                                                                                   @PathVariable String endTime, @RequestBody Request request) throws IOException {
        DeviceDto deviceDto = (DeviceDto) request.getObject();
        return activityService.getCaloriesOfDayBetweenTwoTimesPerMinuteFromApi(date, startTime, endTime, deviceDto);
    }


}
