package com.example.umc10th.domain.mission.service;

import com.example.umc10th.domain.mission.converter.MissionConverter;
import com.example.umc10th.domain.mission.dto.MissionReqDTO;
import com.example.umc10th.domain.mission.dto.MissionResDTO;
import com.example.umc10th.domain.mission.entity.Mission;
import com.example.umc10th.domain.mission.enums.MissionStatus;
import com.example.umc10th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;

    public MissionResDTO.MissionListDTO getMissionsByRegion(Long regionID, MissionStatus status) {

        // RegionRepository 없이 바로 ID로 미션들을 찾아옵니다.
        List<Mission> missionList = missionRepository.findAllByStoreRegionIdAndStatus(regionID, status);

        return MissionConverter.toMissionListDTO(missionList);
    }

    // Query Parameter
    public String singleParameter(
            String singleParameter
    ){
        return singleParameter;
    }

    // Request Body
    public MissionResDTO.RequestBody requestBody(
            MissionReqDTO.RequestBody dto
    ){
        return MissionConverter.toRequestBody(dto.stringTest(), dto.longTest());
    }
}
