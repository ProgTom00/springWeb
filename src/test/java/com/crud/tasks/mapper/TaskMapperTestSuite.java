package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TaskMapperTestSuite {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    void mapToTaskTest() {
        // Given
        TaskDto taskDto = new TaskDto(1L, "title", "content");
        // When
        Task mappedTask = taskMapper.mapToTask(taskDto);
        // Then
        assertSame(mappedTask.getClass(), Task.class);
        assertEquals(taskDto.getId(), mappedTask.getId());
    }
    @Test
    void mapToTaskDtoTest() {
        // Given
        Task task = new Task(1L, "title","content");
        // When
        TaskDto mappedTaskDto = taskMapper.mapToTaskDto(task);
        // Then
        assertSame(mappedTaskDto.getClass(), TaskDto.class);
        assertEquals(task.getTitle(), mappedTaskDto.getTitle());
    }
    @Test
    void mapToTaskDToList() {
        // Given
        Task task = new Task(1L,"title","content");
        List<Task> taskList = new ArrayList<>();
        Collections.addAll(taskList,task);
        // When
        List<TaskDto> mappedList = taskMapper.mapToTaskDtoList(taskList);
        // Then
        assertNotNull(mappedList);
        assertEquals(1, mappedList.size());
        assertSame(mappedList.get(0).getClass(), TaskDto.class);

    }
}
