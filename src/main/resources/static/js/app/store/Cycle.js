Ext.define('apiDemo.store.Cycle', {
    extend: 'Ext.data.Store',

    alias: 'store.cicle',

    fields: [
        'accountId'
    ],

    data: { items: [
        { name: 'Actual'                   , id: '1' }
        /*,
        { name: '05/May/2018 - 04/Jun/2018', id: '201805' },
        { name: '05/Abr/2018 - 04/May/2018', id: '201804' },
        { name: '05/Mar/2018 - 04/Abr/2018', id: '201803' },
        { name: '05/Feb/2018 - 04/Mar/2018', id: '201802' },
        { name: '05/Ene/2018 - 04/Feb/2018', id: '201801' },
        { name: '05/Dic/2017 - 04/Ene/2018', id: '201712' },
        { name: '05/Nov/2017 - 04/Dic/2017', id: '201711' },
        { name: '05/Oct/2017 - 04/Nov/2017', id: '201710' },
        { name: '05/Sep/2017 - 04/Oct/2017', id: '201709' },
        { name: '05/Jun/2017 - 04/Sep/2017', id: '201708' }
        */
    ]},

    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            rootProperty: 'items'
        }
    }
});
