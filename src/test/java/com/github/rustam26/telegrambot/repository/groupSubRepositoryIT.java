package com.github.rustam26.telegrambot.repository;


import com.github.rustam26.telegrambot.repository.entity.GroupSub;
import com.github.rustam26.telegrambot.repository.entity.TelegramUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;


import java.util.List;
import java.util.Optional;

import static  org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class groupSubRepositoryIT {


    @Autowired
    private GroupSubRepository groupSubRepository;

    @Sql(scripts = {"/sql/clearDbs.sql", "/sql/fiveUsersForGroupSub.sql"})
    @Test
    public void shouldProperlyGetAllUsersForGroupSub(){
        Optional<GroupSub> groupSubFromDB = groupSubRepository.findById(1);

        Assertions.assertTrue(groupSubFromDB.isPresent());
        Assertions.assertEquals(1,groupSubFromDB.get().getId());
        List<TelegramUser> users =  groupSubFromDB.get().getUsers();
        for (int i = 0; i < users.size(); i++) {
            Assertions.assertEquals(Long.valueOf(i +1), users.get(i).getChatId());
            Assertions.assertTrue(users.get(i).isActive());

        }
    }

}
