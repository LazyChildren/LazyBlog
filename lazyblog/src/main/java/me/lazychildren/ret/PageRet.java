package me.lazychildren.ret;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.lazychildren.entity.Dairy;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRet {
    private int curpage;
    private int totalpage;
    private int size;
    private List<Dairy> dairies;
}
