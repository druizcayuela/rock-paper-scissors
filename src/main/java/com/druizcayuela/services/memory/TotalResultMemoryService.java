package com.druizcayuela.services.memory;

import com.druizcayuela.domain.TotalResult;
import com.druizcayuela.services.TotalResultService;
import org.springframework.stereotype.Service;

/**
 * The result memory service bean
 *
 * @author druizcayuela
 *
 */

@Service
public class TotalResultMemoryService extends AbstractMemoryService<TotalResult> implements TotalResultService {
}
