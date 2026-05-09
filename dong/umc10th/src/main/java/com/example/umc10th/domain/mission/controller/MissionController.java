package com.example.umc10th.domain.mission.controller;

import com.example.umc10th.domain.mission.dto.MissionReqDTO;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.enums.MissionStatus;
import com.example.umc10th.domain.mission.service.MissionService;
import com.example.umc10th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/region/{regionID}")
    public ApiResponse<MissionResDTO.MissionListDTO> getRegionMissions(
            @PathVariable(name = "regionID") Long regionID,
            @RequestParam(defaultValue = "CHALLENGING") MissionStatus status
    ) {
        // MissionService의 메서드를 호출
        MissionResDTO.MissionListDTO response = missionService.getMissionsByRegion(regionID, status);

        return ApiResponse.onSuccess(response);
    }


    /*
    // 아무것도 받지 않은 경우
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    // Query Parameter
    @PostMapping("/query-parameter")
    public String exception(
            @RequestParam String queryParameter
    ){
        return missionService.singleParameter(queryParameter);
    }

    // Request Body 
    @PostMapping("/request-body")
    public MissionResDTO.RequestBody requestBody(
            @RequestBody MissionReqDTO.RequestBody dto
    ){
        return missionService.requestBody(dto);
    }

    // Path Variable
    @PostMapping("/{pathVariable}")
    public String pathVariable(
            @PathVariable String pathVariable
    ){
        return missionService.singleParameter(pathVariable);
    }

    // Header
    @PostMapping("/header")
    public String header(
            @RequestHeader("test") String test
    ){
        return missionService.singleParameter(test);
    }

     */
}
