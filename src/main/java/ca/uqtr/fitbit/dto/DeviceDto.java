package ca.uqtr.fitbit.dto;

import ca.uqtr.fitbit.entity.Device;
import ca.uqtr.fitbit.entity.PatientDevice;
import ca.uqtr.fitbit.entity.fitbit.Auth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {

    private String id;
    private String deviceId;
    private String deviceVersion;
    private String type;
    private Date lastSyncDate;
    private String adminId;
    private boolean available;
    private String institutionCode;
    private Auth auth;
    private List<PatientDevice> patientDevices;

    public Device dtoToObj(ModelMapper modelMapper) {
        return modelMapper.map(this, Device.class);
    }

}
