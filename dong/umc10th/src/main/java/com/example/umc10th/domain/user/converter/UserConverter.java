package com.example.umc10th.domain.user.converter;

import com.example.umc10th.domain.mission.converter.MissionConverter;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.Mission;
import com.example.umc10th.domain.mission.entity.mapping.UserMission;
import com.example.umc10th.domain.user.dto.UserResDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public static UserResDTO.UserMissionDetailDTO toUserMissionDetailDTO(UserMission userMission){
        return UserResDTO.UserMissionDetailDTO.builder()
                .missionId(userMission.getMission().getId())
                .point(userMission.getMission().getPoint())
                .missionSpec(userMission.getMission().getMissionSpec())
                .storeName(userMission.getMission().getStore().getStore_name())
                .status(userMission.getStatus())
                .deadline(userMission.getMission().getDeadline())
                .build();
    }

    public static UserResDTO.UserMissionListDTO toUserMissionListDTO(List<UserMission> userMissionList) {
        List<UserResDTO.UserMissionDetailDTO> detailDTOList = userMissionList.stream()
                .map(UserConverter::toUserMissionDetailDTO)
                .collect(Collectors.toList());

        return UserResDTO.UserMissionListDTO.builder()
                .userMissionDetailDTOList(detailDTOList)
                .listSize(detailDTOList.size())
                .build();
    }
}
