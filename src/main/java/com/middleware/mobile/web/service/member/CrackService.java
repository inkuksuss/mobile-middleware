package com.middleware.mobile.web.service.member;

import com.middleware.mobile.domain.dto.CrackDto;
import com.middleware.mobile.domain.response.ResultCode;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.repository.CrackRepository;
import com.middleware.mobile.web.utils.StatusCheckUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrackService {

    private final CrackRepository crackRepository;


    public ResultResponse<List<CrackDto>> getCrackList(CrackDto crackDto) throws SQLException {
        List<CrackDto> crackList = crackRepository.getCrackList(crackDto);
        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), crackList);
    }

    public ResultResponse<CrackDto> insertCrack(CrackDto crackDto) throws SQLException {
        int result = crackRepository.insertCrack(crackDto);
        if (result == 1) {
            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), crackDto);
        } else {
            return new ResultResponse<>(HttpStatus.OK, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
        }
    }

    public ResultResponse<CrackDto> updateCrack(CrackDto crackDto) throws SQLException {
        int result = crackRepository.updateCrack(crackDto);
        if (result == 1) {
            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), crackDto);
        } else {
            return new ResultResponse<>(HttpStatus.OK, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
        }
    }

    public ResultResponse<CrackDto> deleteCrack(CrackDto crackDto) throws SQLException {
        int result = crackRepository.deleteCrack(crackDto);
        if (result == 1) {
            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
        } else {
            return new ResultResponse<>(HttpStatus.OK, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
        }
    }
}
