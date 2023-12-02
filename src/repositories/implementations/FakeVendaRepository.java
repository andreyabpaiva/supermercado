package repositories.implementations;

import identidades.Venda;
import repositories.IVendaRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeVendaRepository implements IVendaRepository {
    public static final FakeVendaRepository I = new FakeVendaRepository();

    private static final List<Venda> vendaList = new ArrayList<>();

    @Override
    public List<Venda> findAll() {
        return vendaList;
    }

    @Override
    public void create(Venda model) {
        vendaList.add(model);
    }

    @Override
    public void remove(Venda model) {
        vendaList.remove(model);
    }
}
