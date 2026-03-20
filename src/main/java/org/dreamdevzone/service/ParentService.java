package org.dreamdevzone.service;

import java.util.List;

import org.dreamdevzone.model.dto.ParentDto;
import org.springframework.data.domain.Pageable;


public interface ParentService {
void add(ParentDto dto);
ParentDto get(Integer id);
List<ParentDto> getAll(Pageable pageable);
void delete(Integer id);
ParentDto update(Integer id, ParentDto dto);
}
