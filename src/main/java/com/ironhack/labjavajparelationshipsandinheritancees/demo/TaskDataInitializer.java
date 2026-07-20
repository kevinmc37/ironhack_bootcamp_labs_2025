package com.ironhack.labjavajparelationshipsandinheritancees.demo;

import com.ironhack.labjavajparelationshipsandinheritancees.model.TaskManagement.BillableTask;
import com.ironhack.labjavajparelationshipsandinheritancees.model.TaskManagement.InternalTask;
import com.ironhack.labjavajparelationshipsandinheritancees.model.TaskManagement.Task;
import com.ironhack.labjavajparelationshipsandinheritancees.repository.BillableTaskRepository;
import com.ironhack.labjavajparelationshipsandinheritancees.repository.InternalTaskRepository;
import com.ironhack.labjavajparelationshipsandinheritancees.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class TaskDataInitializer implements CommandLineRunner {
    private final TaskRepository taskRepository;
    private final BillableTaskRepository billableTaskRepository;
    private final InternalTaskRepository internalTaskRepository;

    public TaskDataInitializer(TaskRepository taskRepository,
                               BillableTaskRepository billableTaskRepository,
                               InternalTaskRepository internalTaskRepository) {
        this.taskRepository = taskRepository;
        this.billableTaskRepository = billableTaskRepository;
        this.internalTaskRepository = internalTaskRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LocalDate nextYear = LocalDate.now().plusYears(1);
        BigDecimal decimal = new BigDecimal("100000000020000.9199999999992");
        Task task = new Task();
        BillableTask billableTask = new BillableTask();
        InternalTask internalTask = new InternalTask();

        task.setTitle("Create database.");
        task.setDueDate(nextYear);
        task.setCompleted(true);

        billableTask.setTitle("Send all money.");
        billableTask.setDueDate(nextYear);
        billableTask.setCompleted(false);
        billableTask.setHourlyRate(decimal);

        internalTask.setTitle("Happy Birthday Johanne!");
        internalTask.setDueDate(nextYear);
        internalTask.setCompleted(true);

        taskRepository.save(task);
        billableTaskRepository.save(billableTask);
        internalTaskRepository.save(internalTask);

        System.out.println("Tasks created.");
    }
}
