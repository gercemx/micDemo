Ext.define('apiDemo.store.Accounts', {
    extend: 'Ext.data.Store',

    alias: 'store.accounts',

    fields: [
        'accountId'
    ],

    data: { items: [
        { accountId: "100301514", accountName :"Buena" },
        { accountId: "100301515", accountName :"Dos"  },
        { accountId: "100301513", accountName :"Tres"  },
        { accountId: "100301512", accountName :"Cuatro"  }
    ]},

    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            rootProperty: 'items'
        }
    }
});
