package javaman.EncryptData.ActivityLogs;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityLogsService {

    private final ActivityLogsRepository activityLogsRepository;



    public List<ActivityLogsEntity> getAllActivityLogs() {
        return activityLogsRepository.findAll();
    }

    public Optional<ActivityLogsEntity> getActivityLogById(Long id) {
        return activityLogsRepository.findById(id);
    }

    public ActivityLogsEntity saveActivityLog(String user, String action, Long entityId) {

        ActivityLogsEntity activityLog = new ActivityLogsEntity();
        activityLog.setUser(user);
        activityLog.setAction(action);
        activityLog.setEntityId(entityId);

        return activityLogsRepository.save(activityLog);
    }

    public ActivityLogsEntity saveActivityLogin(String user, String action) {

        ActivityLogsEntity activityLog = new ActivityLogsEntity();
        activityLog.setUser(user);
        activityLog.setAction(action);

        return activityLogsRepository.save(activityLog);
    }


    }
