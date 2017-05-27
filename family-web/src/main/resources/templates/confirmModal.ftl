<div class="modal fade top-modal-without-space" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">系统消息</h4>
                </div>
                <div class="modal-body">
                    确认删除?
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                    <button class="btn btn-warning" @click="confirmModal" type="button"> 确定</button>
                </div>
            </div>
        </div>
    </div>
</div>