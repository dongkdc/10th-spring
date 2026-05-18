package com.example.umc10th.domain.user.service;

import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import com.example.umc10th.domain.mission.enums.MissionStatus;
import com.example.umc10th.domain.user.repository.UserMissionRepository;
import com.example.umc10th.domain.user.converter.UserConverter;
import com.example.umc10th.domain.user.dto.UserResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMissionRepository userMissionRepository;

    public UserResDTO.UserMissionListDTO getMissionsByUserID(Long userId, MissionStatus status, Integer page) {
        int limit = 10;
        int offset = page * limit;

        List<UserMission> userMissionList = userMissionRepository.findAllByUserIdAndStatus(userId, status);
        return UserConverter.toUserMissionListDTO(userMissionList);
    }

}
