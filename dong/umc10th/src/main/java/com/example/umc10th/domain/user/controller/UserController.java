package com.example.umc10th.domain.user.controller;

import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.enums.MissionStatus;
import com.example.umc10th.domain.mission.service.MissionService;
import com.example.umc10th.domain.user.dto.UserResDTO;
import com.example.umc10th.domain.user.service.UserService;
import com.example.umc10th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 내 미션을 모아서 보는 쿼리(진행중/완료)
    @GetMapping("/{userID}/missions")
    public ApiResponse<UserResDTO.UserMissionListDTO> getUserMissions(
            @PathVariable(name = "userID") Long userID,
            @RequestParam(defaultValue = "CHALLENGING") MissionStatus status,
            @RequestParam(defaultValue = "0") Integer page
    ) {
        UserResDTO.UserMissionListDTO response = userService.getMissionsByUserID(userID, status, page);

        return ApiResponse.onSuccess(response);
    }
}
